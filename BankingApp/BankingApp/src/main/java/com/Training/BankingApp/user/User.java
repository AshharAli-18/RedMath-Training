package com.Training.BankingApp.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "users")
public class User {

    @Id
    private long userId;
    private String username;
    private String password;
    private String email;
    private long phoneNumber;
    private int role_id;

}
