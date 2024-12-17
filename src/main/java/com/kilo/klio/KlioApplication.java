package com.kilo.klio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.kilo.klio.controller") // controller 패키지 추가
public class KlioApplication {

	public static void main(String[] args) {
		SpringApplication.run(KlioApplication.class, args);
	}
}
