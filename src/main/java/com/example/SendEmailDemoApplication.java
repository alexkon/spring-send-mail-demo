package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SendEmailDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendEmailDemoApplication.class, args);
		System.out.println("http://localhost:8080/signup");
		System.out.println("http://localhost:8080/signup-success");
	}
}
