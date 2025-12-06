package com.playstore.owner.controller;

import com.playstore.owner.model.App;
import com.playstore.owner.service.AppService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.playstore.owner.dto.ReviewDto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/owners/apps")
@CrossOrigin(origins = "http://localhost:8081")
public class AppController {

    private final AppService service;
    private final RestTemplate restTemplate = new RestTemplate();

    public AppController(AppService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<App> createApp(@RequestBody App app,
                                         Authentication authentication) {
        String ownerEmail = authentication.getName();
        App created = service.createAppForOwner(ownerEmail, app);
        return ResponseEntity.ok(created);
    }
    

    @PostMapping("/{id}/rating")
    public ResponseEntity<Void> updateAverageRating(@PathVariable Long id,
                                                    @RequestBody Map<String, Double> body) {
        Double avg = body.get("averageRating");
        service.updateAverageRating(id, avg != null ? avg : 0.0);
        return ResponseEntity.ok().build();
    }

    
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<App>> getAppsByOwner(@PathVariable Long ownerId) {
        return ResponseEntity.ok(service.getAppsByOwner(ownerId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<App> getApp(@PathVariable Long id) {
        return service.getApp(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<App> updateApp(@PathVariable Long id, @RequestBody App app) {
        return service.updateApp(id, app)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/visibility")
    public ResponseEntity<App> changeVisibility(@PathVariable Long id,
                                                @RequestParam boolean visible) {
        return service.changeVisibility(id, visible)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApp(@PathVariable Long id) {
        service.deleteApp(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/public")
    public List<App> getPublicApps(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) String genre) {
        return service.searchPublic(name, genre);
    }

    
    @PostMapping("/{id}/download")
    public ResponseEntity<Void> recordDownload(@PathVariable Long id) {
        service.incrementDownloadCount(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{id}/reviews")
    public ResponseEntity<List<ReviewDto>> getReviews(@PathVariable Long id) {
        var res = restTemplate.getForEntity(
                "http://localhost:8081/api/user/apps/" + id + "/reviews",  // ✅ FIXED PATH
                ReviewDto[].class
        );
        ReviewDto[] reviewsArray = res.getBody();
        List<ReviewDto> reviewsList = reviewsArray != null ? Arrays.asList(reviewsArray) : List.of();
        return ResponseEntity.ok(reviewsList);
    }
    
    @PostMapping("/{id}/reviews/respond")
    public ResponseEntity<String> respondToReview(@PathVariable Long id,
                                                  @RequestBody String responseText) {
        System.out.println("Owner response for app " + id + ": " + responseText);
        return ResponseEntity.ok("Response saved");
    }
}
