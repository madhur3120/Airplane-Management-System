package com.example.airplane_management_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AirplaneManagementServiceApplication {
	private static final Logger logger = LoggerFactory.getLogger(AirplaneManagementServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AirplaneManagementServiceApplication.class, args);
		logger.info("Application Started");
	}

}
