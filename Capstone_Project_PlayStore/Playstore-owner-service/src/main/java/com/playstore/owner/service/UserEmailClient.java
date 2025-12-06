package com.playstore.owner.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserEmailClient {

    private final RestTemplate restTemplate;

    @Value("${user.service.base-url:http://localhost:8081}")
    private String userServiceBaseUrl;

    public UserEmailClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<String> getEmailsForApp(Long appId) {
        String url = userServiceBaseUrl + "/api/user/notifications/emails/" + appId;
        String[] arr = restTemplate.getForObject(url, String[].class);
        return arr == null ? List.of() : Arrays.asList(arr);
    }
}
