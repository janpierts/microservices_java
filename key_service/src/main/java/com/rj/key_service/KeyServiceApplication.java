package com.rj.key_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KeyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeyServiceApplication.class, args);
	}

}
