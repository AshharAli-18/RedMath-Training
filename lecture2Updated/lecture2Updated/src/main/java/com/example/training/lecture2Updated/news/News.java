package com.example.training.lecture2Updated.news;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class News {
    @Id
    private Long newsId;
    private String title;
    private String details;
    private String reportedBy;
    private LocalDateTime reportedAt;
}
