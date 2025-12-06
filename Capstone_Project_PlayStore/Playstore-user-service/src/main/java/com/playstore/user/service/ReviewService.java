package com.playstore.user.service;

import com.playstore.user.dto.ReviewRequest;
import com.playstore.user.dto.ReviewResponse;
import com.playstore.user.exception.UserNotFoundException;
import com.playstore.user.model.Review;
import com.playstore.user.model.User;
import com.playstore.user.repositry.ReviewRepository;
import com.playstore.user.repositry.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepo;
    private final UserRepository userRepo;
    private final AppRatingClient appRatingClient;
    public ReviewService(ReviewRepository reviewRepo, UserRepository userRepo, AppRatingClient appRatingClient) {
        this.reviewRepo = reviewRepo;
        this.userRepo = userRepo;
        this.appRatingClient = appRatingClient;
    }

    public ReviewResponse createReview(String userEmail, ReviewRequest request) {
        User user = userRepo.findByEmail(userEmail)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Review review = new Review();
        review.setAppId(request.getAppId());
        review.setUserId(user.getId());
        review.setUserEmail(user.getEmail());
        review.setRating(request.getRating());
        review.setComment(request.getComment());

        Review saved = reviewRepo.save(review);
        List<Review> all = reviewRepo.findByAppId(request.getAppId());
        double avg = all.stream()
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0);

        try {
            appRatingClient.updateAverageRating(request.getAppId(), avg);
        } catch (Exception ex) {
            ex.printStackTrace(); 
        }
        return toResponse(saved);
    }

    public List<ReviewResponse> getReviewsForApp(Long appId) {
        return reviewRepo.findByAppId(appId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<ReviewResponse> getReviewsByUser(Long userId) {
        return reviewRepo.findByUserId(userId)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private ReviewResponse toResponse(Review r) {
        ReviewResponse dto = new ReviewResponse();
        dto.setId(r.getId());
        dto.setAppId(r.getAppId());
        dto.setUserId(r.getUserId());
        dto.setUserEmail(r.getUserEmail());
        dto.setRating(r.getRating());
        dto.setComment(r.getComment());
        dto.setCreatedAt(r.getCreatedAt());
        return dto;
    }
}
