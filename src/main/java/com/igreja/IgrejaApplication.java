package com.igreja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.igreja")
public class IgrejaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgrejaApplication.class, args);
	}
}
