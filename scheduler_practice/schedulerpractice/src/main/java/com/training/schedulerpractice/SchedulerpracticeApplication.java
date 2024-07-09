package com.training.schedulerpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.logging.Logger;

@SpringBootApplication
@EnableScheduling
public class SchedulerpracticeApplication {

	Logger logger  = Logger.getLogger("SchedulerpracticeApplication");

	public static void main(String[] args) {
		SpringApplication.run(SchedulerpracticeApplication.class, args);
	}

//	@Scheduled(fixedRate = 2000)  //Because of fixed rate it will not wait for the sleep
//	public void job() throws InterruptedException {
//		logger.info("Job current time is :" + new Date());
//		Thread.sleep(2000);
//	}

//  @Scheduled(fixedDelay = 2000, initialDelay = 2000)  //Because of fixed delay, after method execution, it will wait for the delay period and initial delay is the time to wait after the application starts
//	public void job() throws InterruptedException {
//		logger.info("Job current time is :" + new Date());
//		Thread.sleep(2000);
//	}

//	@Scheduled(fixedDelayString = "PT1S", initialDelay = 2000)  //We can also use the java duration unit as the values sometimes can be confusing
//	public void job() throws InterruptedException {
//		logger.info("Job current time is :" + new Date());
//		Thread.sleep(2000);
//	}

	@Scheduled(cron = "*/2 * * * * *")  //We can also use cron for generating different expressions
	public void job1() throws InterruptedException {
		logger.info("Job1 current time is :" + new Date());
		Thread.sleep(2000);
	}

	@Scheduled(cron = "*/2 * * * * *")
	public void job2() throws InterruptedException {  //Now job1 AND job2 are running on separate threads
		logger.info("Job2 current time is :" + new Date());
		Thread.sleep(2000);
	}
}
