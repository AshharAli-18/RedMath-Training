package com.Lec4.SnookerClubManagementSystem.frame;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "frames")
public class Frame {
    @Id
    private int frameId;
    private String player1;
    private String player2;
    private String winner;
    private String reportedBy;
    private LocalDateTime reportedOn;
}
