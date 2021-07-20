package com.aamer.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Defines a configuration class that declares one or more bean methods
// and also trigger auto-configuration and component scan.
//
// A class annotated with @SpringBootApplication will consist of @Configuration , @EnableAutoconfiguration and @ComponentScan annotations.
// Auto-configuration : automatically configure (resolve) the spring application based on jar dependencies
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootApplication.class, args);

	}
}
