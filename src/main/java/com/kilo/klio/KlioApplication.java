package com.kilo.klio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.kilo.klio")
public class KlioApplication {

	public static void main(String[] args) {
		SpringApplication.run(KlioApplication.class, args);
	}
}
