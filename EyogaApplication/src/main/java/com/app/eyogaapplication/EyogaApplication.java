package com.app.eyogaapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.app.eyogaapplication" })
@SpringBootApplication
public class EyogaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EyogaApplication.class, args);
	}
}
