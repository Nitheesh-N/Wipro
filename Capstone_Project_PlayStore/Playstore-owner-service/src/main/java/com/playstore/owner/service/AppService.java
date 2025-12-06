package com.playstore.owner.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.playstore.owner.model.Announcement;
import com.playstore.owner.model.App;
import com.playstore.owner.model.DownloadEvent;
import com.playstore.owner.model.Owner;
import com.playstore.owner.repository.AnnouncementRepository;
import com.playstore.owner.repository.AppRepository;
import com.playstore.owner.repository.DownloadEventRepository;

@Service
public class AppService {

    private final AppRepository repo;
    private final OwnerService ownerService;
    private final DownloadEventRepository downloadEventRepository;
    private final AnnouncementRepository announcementRepository;
    private final RestTemplate restTemplate;
    private final UserEmailClient userEmailClient;   

    @Value("${notification.service.base-url:http://localhost:8083}")
    private String notificationBaseUrl;

    public AppService(AppRepository repo,
                      OwnerService ownerService,
                      DownloadEventRepository downloadEventRepository,
                      AnnouncementRepository announcementRepository,
                      RestTemplate restTemplate,
                      UserEmailClient userEmailClient) {
        this.repo = repo;
        this.ownerService = ownerService;
        this.downloadEventRepository = downloadEventRepository;
        this.announcementRepository = announcementRepository;
        this.restTemplate = restTemplate;
        this.userEmailClient = userEmailClient;
    }

    public App createAppForOwner(String ownerEmail, App app) {
        Owner owner = ownerService.findByEmail(ownerEmail);
        if (owner == null) {
            throw new RuntimeException("Owner not found for email: " + ownerEmail);
        }
        app.setId(null);
        app.setOwnerId(owner.getId());
        return repo.save(app);
    }

    public List<App> getAppsByOwner(Long ownerId) {
        return repo.findByOwnerId(ownerId);
    }

    public Optional<App> getApp(Long id) {
        return repo.findById(id);
    }

    public Optional<App> updateApp(Long id, App updated) {
        return repo.findById(id).map(existing -> {
            existing.setName(updated.getName());
            existing.setDescription(updated.getDescription());
            existing.setVisible(updated.isVisible());
            existing.setVersion(updated.getVersion());
            existing.setGenre(updated.getGenre());
            existing.setReleaseDate(updated.getReleaseDate());
            return repo.save(existing);
        });
    }

    public Optional<App> changeVisibility(Long id, boolean visible) {
        return repo.findById(id).map(existing -> {
            existing.setVisible(visible);
            return repo.save(existing);
        });
    }

    public void deleteApp(Long id) {
        repo.deleteById(id);
    }

    public void incrementDownloadCount(Long appId) {
        repo.findById(appId).ifPresent(app -> {
            app.setDownloadCount(app.getDownloadCount() + 1);
            repo.save(app);

            DownloadEvent event = new DownloadEvent();
            event.setAppId(app.getId());
            event.setAppName(app.getName());
            event.setUserEmail(null); 
            event.setCreatedAt(LocalDateTime.now());
            downloadEventRepository.save(event);
        });
    }

    public List<DownloadEvent> getRecentDownloadEvents() {
        return downloadEventRepository.findTop10ByOrderByCreatedAtDesc();
    }

    
    public Announcement createAnnouncement(Long appId, String title, String message) {
        App app = repo.findById(appId)
                .orElseThrow(() -> new RuntimeException("App not found"));

        Announcement a = new Announcement();
        a.setAppId(app.getId());
        a.setAppName(app.getName());
        a.setTitle(title);
        a.setMessage(message);
        a.setCreatedAt(LocalDateTime.now());
        Announcement saved = announcementRepository.save(a);

        sendUpdateEmails(app, title, message);

        return saved;
    }

    
    private void sendUpdateEmails(App app, String title, String message) {
        List<String> emails = userEmailClient.getEmailsForApp(app.getId());
        if (emails == null || emails.isEmpty()) {
            return;
        }

        String url = notificationBaseUrl + "/api/notifications/email";

        for (String email : emails) {
            Map<String, String> body = Map.of(
                    "to", email,
                    "subject", "Update for " + app.getName(),
                    "body", title + "\n\n" + message
            );
            restTemplate.postForEntity(url, body, Void.class);
        }
    }

    public List<Announcement> getAnnouncementsForApp(Long appId) {
        return announcementRepository.findTop10ByAppIdOrderByCreatedAtDesc(appId);
    }

    public List<App> searchPublic(String name, String genre) {
        if (name != null && !name.isBlank() && genre != null && !genre.isBlank()) {
            return repo.findByVisibleTrueAndNameContainingIgnoreCaseAndGenreIgnoreCase(name, genre);
        } else if (name != null && !name.isBlank()) {
            return repo.findByVisibleTrueAndNameContainingIgnoreCase(name);
        } else if (genre != null && !genre.isBlank()) {
            return repo.findByVisibleTrueAndGenreIgnoreCase(genre);
        } else {
            return repo.findByVisibleTrue();
        }
    }

    public void updateAverageRating(Long appId, double avg) {
        App app = repo.findById(appId)
                .orElseThrow(() -> new RuntimeException("App not found"));
        app.setAverageRating(avg);
        repo.save(app);
    }
}
