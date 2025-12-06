package com.playstore.notification.controller;

import com.playstore.notification.dto.EmailRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class EmailNotificationController {

    private final JavaMailSender mailSender;

    public EmailNotificationController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @PostMapping("/email")
    public ResponseEntity<Void> sendEmail(@RequestBody EmailRequest req) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(req.getTo());
        msg.setSubject(req.getSubject());
        msg.setText(req.getBody());
        mailSender.send(msg);
        return ResponseEntity.ok().build();
    }
}
