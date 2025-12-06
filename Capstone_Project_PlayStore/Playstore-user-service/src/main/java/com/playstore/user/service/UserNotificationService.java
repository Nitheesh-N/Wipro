package com.playstore.user.service;

import com.playstore.user.repositry.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserNotificationService {

    private final ReviewRepository reviewRepository;

    public UserNotificationService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<String> getEmailsForApp(Long appId) {
        return reviewRepository.findDistinctUserEmailsByAppId(appId);
    }
}
