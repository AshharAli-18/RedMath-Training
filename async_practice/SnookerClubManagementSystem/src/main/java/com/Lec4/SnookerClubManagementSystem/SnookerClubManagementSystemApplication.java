package com.Lec4.SnookerClubManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SnookerClubManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnookerClubManagementSystemApplication.class, args);
	}

}
