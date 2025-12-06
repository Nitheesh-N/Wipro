package com.playstore.owner.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "apps")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class App {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    @Column(length = 2000)
    private String description;

    @Column(nullable = false)
    private boolean visible = true;

    @Column(nullable = false)
    private Long ownerId;
    
    private long downloadCount = 0;
    private String version;
    private String genre;
    private String releaseDate;
    private double averageRating = 0.0;
    public Double getAverageRating() { return averageRating; }
    public void setAverageRating(Double averageRating) { this.averageRating = averageRating; }
}
