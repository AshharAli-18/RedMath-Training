package com.Training.BankingApp.transfer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransferRequest {

    private long fromAccountId;
    private String toAccountNumber;
    private long amount;

}
