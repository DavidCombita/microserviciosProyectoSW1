package com.davidcombita.mstattos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MsTattosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTattosApplication.class, args);
	}

}
