package com.playstore.user.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DownloadService {

    private final RestTemplate restTemplate;

    
    private static final String OWNER_BASE_URL = "http://localhost:8082/api/owners/apps";

    public DownloadService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void downloadApp(Long appId) {
        String url = OWNER_BASE_URL + "/" + appId + "/download";
        restTemplate.postForEntity(url, null, Void.class);
    }
}
