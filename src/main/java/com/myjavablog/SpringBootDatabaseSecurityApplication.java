package com.myjavablog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootDatabaseSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDatabaseSecurityApplication.class, args);
	}

}

