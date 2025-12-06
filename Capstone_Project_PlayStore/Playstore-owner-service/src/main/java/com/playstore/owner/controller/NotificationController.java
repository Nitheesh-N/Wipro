package com.playstore.owner.controller;

import com.playstore.owner.model.DownloadEvent;
import com.playstore.owner.service.AppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners/notifications")
@CrossOrigin(origins = "http://localhost:8081")
public class NotificationController {

    private final AppService appService;

    public NotificationController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping("/downloads")
    public ResponseEntity<List<DownloadEvent>> getRecentDownloads() {
        return ResponseEntity.ok(appService.getRecentDownloadEvents());
    }
}
