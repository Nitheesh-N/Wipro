package com.playstore.user.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class AppRatingClient {

    private final RestTemplate restTemplate;

    private static final String OWNER_BASE_URL = "http://localhost:8082/api/owners/apps";

    public AppRatingClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void updateAverageRating(Long appId, double avgRating) {
        String url = OWNER_BASE_URL + "/" + appId + "/rating";
        Map<String, Object> body = Map.of("averageRating", avgRating);
        restTemplate.postForEntity(url, body, Void.class);
    }
}
