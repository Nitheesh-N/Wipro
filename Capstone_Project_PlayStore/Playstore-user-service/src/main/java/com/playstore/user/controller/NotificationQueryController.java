package com.playstore.user.controller;

import com.playstore.user.service.UserNotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/notifications")
public class NotificationQueryController {

    private final UserNotificationService userNotificationService;

    public NotificationQueryController(UserNotificationService userNotificationService) {
        this.userNotificationService = userNotificationService;
    }

    @GetMapping("/emails/{appId}")
    public ResponseEntity<List<String>> getEmails(@PathVariable Long appId) {
        return ResponseEntity.ok(userNotificationService.getEmailsForApp(appId));
    }
}
