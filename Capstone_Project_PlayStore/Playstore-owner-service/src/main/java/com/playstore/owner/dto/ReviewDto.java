package com.playstore.owner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private Long id;
    private Long appId;
    private String userEmail;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;
}
