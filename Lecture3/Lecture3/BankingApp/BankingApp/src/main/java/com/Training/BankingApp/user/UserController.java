package com.Training.BankingApp.user;

import com.Training.BankingApp.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/api/loginCustomer")
    public ResponseEntity<?> loginCustomer(@RequestBody LoginRequest loginRequest) {
        try{
            ResponseEntity<?> response = userService.loginCustomer(loginRequest);
            if (response.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.ok("User Logged in successfully");
            } else {
                return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/api/loginAdmin")
    public String loginAdmin(@RequestBody LoginRequest loginRequest) {
        try{
            ResponseEntity<?> response = userService.loginAdmin(loginRequest);
            if (response.getStatusCode().is2xxSuccessful()) {
                String token = jwtUtil.generateToken(loginRequest.getEmail());
                return token;
//                return ResponseEntity.ok("User Logged in successfully");
            } else {
                return String.valueOf(ResponseEntity.status(response.getStatusCode()).body(response.getBody()));
            }
        } catch (Exception e) {
            return String.valueOf(ResponseEntity.badRequest().body(e.getMessage()));
        }
    }

    @GetMapping("/api/getUsers")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}
