package com.org.party_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PartyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartyManagementApplication.class, args);
	}

}
