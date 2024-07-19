package com.Training.BankingApp.user;

import com.Training.BankingApp.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@Service
public class UserService {


    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    public ResponseEntity<?> loginCustomer(@org.jetbrains.annotations.NotNull LoginRequest loginRequest) {
        User user = new User();
        user=userRepository.findOneByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());

        if(user==null) {
               return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
        if(user.getRoleId()!=2L) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid role");
        }

        return ResponseEntity.ok(user);
    }

    public ResponseEntity<?> loginAdmin(@org.jetbrains.annotations.NotNull LoginRequest loginRequest) {
        User user = new User();
        user=userRepository.findOneByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());

        if(user==null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
        if(user.getRoleId()!=1L) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid role");
        }

        return ResponseEntity.ok(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
