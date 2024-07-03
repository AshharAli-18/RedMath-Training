package com.training.practice.lec1.Lecture1;   //Package are used to group related classes together, Moreover it can prevent conflicts it two class have same names etc

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //This annotation marks the class as entrypoint for the app. For spring this class will be a bean. Spring manages all beans and inject dependencies in it
public class Lecture1Application {

	public static void main(String[] args) {  // we use String[] args so that we can pass arguments at runtime in future
		SpringApplication.run(Lecture1Application.class, args);
	}

}
