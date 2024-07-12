package com.Training.BankingApp.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SignupRequest {

    private String username;
    private String password;
    private String email;
    private Long phoneNumber;


}