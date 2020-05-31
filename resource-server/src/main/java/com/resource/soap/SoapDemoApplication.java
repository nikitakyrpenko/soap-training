package com.resource.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.resource.soap", "com.auth.soap.config"})
public class SoapDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapDemoApplication.class, args);
	}

}
