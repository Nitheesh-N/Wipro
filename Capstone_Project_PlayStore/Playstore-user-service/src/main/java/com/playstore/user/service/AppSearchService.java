package com.playstore.user.service;

import com.playstore.user.dto.AppSummary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AppSearchService {

    private final RestTemplate restTemplate;

    @Value("${owner.service.base-url:http://localhost:8082}")
    private String ownerServiceBaseUrl;

    public AppSearchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<AppSummary> search(String name, String genre, Double minRating) {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromHttpUrl(ownerServiceBaseUrl + "/api/owners/apps/public");

        Optional.ofNullable(name)
                .filter(s -> !s.isBlank())
                .ifPresent(s -> builder.queryParam("name", s));   

        Optional.ofNullable(genre)
                .filter(s -> !s.isBlank())
                .ifPresent(s -> builder.queryParam("genre", s));

        String url = builder.toUriString();

        AppSummary[] response = restTemplate.getForObject(url, AppSummary[].class);
        List<AppSummary> apps = response == null ? List.of() : Arrays.asList(response);

        
        if (minRating != null) {
            apps = apps.stream()
                    .filter(a -> (a.getAverageRating() != null ? a.getAverageRating() : 0.0) >= minRating)
                    .toList();
        }

        return apps;
    }
}
