package com.Training.BankingApp.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @Autowired
    private TransferService transferService;


    @PostMapping("/api/transferMoney")
    public ResponseEntity<String> transferMoney(@RequestBody TransferRequest transferRequest){
        try{
            transferService.transfer(transferRequest.getFromAccountId(), transferRequest.getToAccountNumber(), transferRequest.getAmount());
            return ResponseEntity.ok("Money transferred successfully");
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
