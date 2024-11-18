package com.onlinevotingsystem.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		System.setProperty("https.protocols", "TLSv1.2");
		SpringApplication.run(AppApplication.class, args);
	}
}
