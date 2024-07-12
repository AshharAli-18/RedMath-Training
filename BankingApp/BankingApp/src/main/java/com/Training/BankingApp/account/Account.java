package com.Training.BankingApp.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity(name = "accounts")
public class Account {

    @Id
    private int accountId;
    private int userId;
    private String accountType;
    private long balance;
    private LocalDate openingDate;

}
