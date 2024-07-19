package com.Training.BankingApp.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String username;
    private String password;
    private String email;
    private long phoneNumber;
    private int roleId;

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", email='" + email + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
