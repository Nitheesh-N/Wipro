package com.playstore.user.controller;

import java.util.List;

import com.playstore.user.dto.ReviewRequest;
import com.playstore.user.dto.ReviewResponse;
import com.playstore.user.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/apps")   
@CrossOrigin(origins = "*")
public class ReviewController {
    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }
    @PostMapping("/{appId}/reviews")
    public ResponseEntity<ReviewResponse> create(
            @PathVariable Long appId,
            @RequestBody ReviewRequest request,
            Authentication authentication) {

        String userEmail = authentication != null ? authentication.getName() : "anonymous";
        request.setAppId(appId);               
        return ResponseEntity.ok(service.createReview(userEmail, request));
    }

    @GetMapping("/{appId}/reviews")
    public ResponseEntity<List<ReviewResponse>> getForApp(@PathVariable Long appId) {
        return ResponseEntity.ok(service.getReviewsForApp(appId));
    }
}
