package com.learning.supermarket.freshmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FreshmarketApplication {

	public static void main(String[] args) {
		System.out.println("Applicationn boot started");
		SpringApplication.run(FreshmarketApplication.class, args);
	}

}
