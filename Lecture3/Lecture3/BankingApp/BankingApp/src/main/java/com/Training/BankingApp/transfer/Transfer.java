package com.Training.BankingApp.transfer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "transfers")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transferId;
    private long transactionId;
    private long fromAccountId;
    private String toAccountNumber;
    private long amount;

}
