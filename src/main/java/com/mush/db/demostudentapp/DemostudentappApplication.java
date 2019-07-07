package com.mush.db.demostudentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.mush.db.demostudentapp.repository")
@SpringBootApplication
public class DemostudentappApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemostudentappApplication.class, args);
	}

}
