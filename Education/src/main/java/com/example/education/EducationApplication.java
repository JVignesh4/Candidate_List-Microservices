package com.example.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EducationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EducationApplication.class, args);
	}

}
