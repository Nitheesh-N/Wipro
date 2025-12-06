package com.playstore.owner.controller;

import com.playstore.owner.model.Announcement;
import com.playstore.owner.service.AppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners/announcements")
@CrossOrigin(origins = "http://localhost:8081")
public class AnnouncementController {

    private final AppService appService;

    public AnnouncementController(AppService appService) {
        this.appService = appService;
    }

    @PostMapping
    public ResponseEntity<Announcement> create(@RequestParam Long appId,
                                               @RequestParam String title,
                                               @RequestParam String message) {
        return ResponseEntity.ok(appService.createAnnouncement(appId, title, message));
    }

    @GetMapping("/app/{appId}")
    public ResponseEntity<List<Announcement>> byApp(@PathVariable Long appId) {
        return ResponseEntity.ok(appService.getAnnouncementsForApp(appId));
    }
}
