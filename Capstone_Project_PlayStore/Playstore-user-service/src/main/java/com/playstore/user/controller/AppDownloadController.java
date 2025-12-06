package com.playstore.user.controller;

import com.playstore.user.service.DownloadService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/apps")
@CrossOrigin(origins = "*")
public class AppDownloadController {

    private final DownloadService downloadService;

    public AppDownloadController(DownloadService downloadService) {
        this.downloadService = downloadService;
    }

    @PostMapping("/{appId}/download")
    public ResponseEntity<String> downloadApp(@PathVariable Long appId,
                                              Authentication authentication) {
        
        downloadService.downloadApp(appId);
        return ResponseEntity.ok("Download recorded");
    }
}
