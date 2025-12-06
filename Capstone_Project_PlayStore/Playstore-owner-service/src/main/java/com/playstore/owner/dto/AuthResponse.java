package com.playstore.owner.dto;

public class AuthResponse {

    private String token;
    private Long ownerId;

    public AuthResponse() {
    }

    public AuthResponse(String token, Long ownerId) {
        this.token = token;
        this.ownerId = ownerId;
    }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
}
