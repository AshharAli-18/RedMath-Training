package com.Training.BankingApp.account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreateRequest {

    //    private int userId;
    private String username;
    private String password;
    private String email;
    private Long phoneNumber;
    private String accountType;


}