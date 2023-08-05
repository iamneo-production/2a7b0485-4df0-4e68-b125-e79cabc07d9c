package com.team30.TrainingSessionManagementService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TrainingSessionManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingSessionManagementServiceApplication.class, args);
	}

}
