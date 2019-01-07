package com.tutorial.spring.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableTransactionManagement
@EnableWebMvc
@EnableJpaRepositories(basePackages = "com.tutorial.spring.backend.repositories")
public class BackendSpringApplication {
	
	
	private static final Logger log = LoggerFactory.getLogger(BackendSpringApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BackendSpringApplication.class, args);
	}

}

