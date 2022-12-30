package com.differentdoors.openproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class OpenprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenprojectApplication.class, args);
	}

}
