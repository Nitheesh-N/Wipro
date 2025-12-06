package com.example.bean;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    private Integer id; // Unique identifier

    @Column(nullable = false)
    private String title; 
    private String description; 
    private String assignedTo; 

    @Column(nullable = false)
    private String priority; 

    @Column(nullable = false)
    private String status; 

    @Column(nullable = false)
    private LocalDate dueDate; 
}

