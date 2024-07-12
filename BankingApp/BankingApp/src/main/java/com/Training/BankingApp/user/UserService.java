package com.Training.BankingApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final AtomicLong counter = new AtomicLong();


    public static long getUniqueID() {
        return counter.incrementAndGet();
    }

    public void registerUser(SignupRequest signupRequest) {
        if(userRepository.existsByUsername(signupRequest.getUsername())) {
            throw new RuntimeException("User already registered!");
        }
        if(userRepository.existsByEmail(signupRequest.getEmail())) {
            throw new RuntimeException("User already registered!");
        }

        User user = new User();
        user.setUserId(getUniqueID());
        user.setUsername(signupRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        user.setPassword(signupRequest.getPassword());
        user.setEmail(signupRequest.getEmail());
        user.setPhoneNumber(signupRequest.getPhoneNumber());
        user.setRole_id(2);

        userRepository.save(user);

    }

}
