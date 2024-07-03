package com.training.practice.lec1.Lecture1;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //Indicates that this class is a controller in a spring application that handles web requests
public class Lecture1Controller {

    @GetMapping("/api/v1/hello-world")   //This annotation maps http get request for the url path
    public ResponseEntity<Map<String, Object>> helloWorld() {
        return ResponseEntity.ok(Map.of("message", "Hello World!", "at", LocalDateTime.now()));
    }

    @GetMapping("/api/v1/hello-world1")   //This annotation maps http get request for the url path
    public ResponseEntity<Map<String, Object>> helloWorld1() {
        return ResponseEntity.ok(Map.of("message", "Hello World1!", "at", LocalDateTime.now()));
    }
}
