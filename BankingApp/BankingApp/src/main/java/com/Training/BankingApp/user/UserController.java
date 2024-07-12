package com.Training.BankingApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/registration")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        try{
            userService.registerUser(signupRequest);
            return ResponseEntity.ok("User registered successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
