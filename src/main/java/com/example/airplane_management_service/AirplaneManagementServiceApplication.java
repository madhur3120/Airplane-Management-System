package com.example.airplane_management_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AirplaneManagementServiceApplication {
	private static final Logger logger = LoggerFactory.getLogger(AirplaneManagementServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AirplaneManagementServiceApplication.class, args);
		logger.info("Application Started");
	}
}
