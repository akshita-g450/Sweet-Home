package com.example.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Entity;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EntityScan(basePackages = "entities")
@EnableJpaRepositories(basePackages = "repository")
@EnableEurekaClient
@EnableZuulProxy
public class RoombookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoombookingApplication.class, args);
	}

}
