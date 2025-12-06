package com.playstore.user.dto;

public class ReviewRequest {
    private Long appId;
    private Integer rating;
    private String comment;

    public Long getAppId() { return appId; }
    public void setAppId(Long appId) { this.appId = appId; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}
