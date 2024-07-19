package com.Training.BankingApp.account;

import com.Training.BankingApp.user.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/api/getAccount/{accountId}")
    public Account getAccount(@PathVariable("accountId") long accountId) {
        return accountService.getAccount(accountId);
    }

    @GetMapping("/api/getAllAccounts")
    public List<Account> getAllAccounts(@RequestParam(name = "page", defaultValue ="0")Integer page, @RequestParam(name = "size", defaultValue ="10")Integer size) {
        return accountService.getAllAccounts(page, size);
    }

    @PutMapping("/api/updateAccount/{id}")
    public void updateAccount(@PathVariable Long id, @RequestBody AccountUpdateRequest accountUpdateRequest) {
        accountUpdateRequest.setAccountId(id);  // Set the ID from the path variable
        accountService.updateAccount(accountUpdateRequest);
    }

    @DeleteMapping("/api/delteAccount/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }

    @PostMapping("/api/createAccount")
    public ResponseEntity<?> registration(@RequestBody AccountCreateRequest accountCreateRequest) {
        try{
            accountService.createAccount(accountCreateRequest);
            return ResponseEntity.ok("Account Created Successfully!");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
