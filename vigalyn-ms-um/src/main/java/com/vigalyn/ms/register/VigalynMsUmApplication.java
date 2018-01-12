package com.vigalyn.ms.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class VigalynMsUmApplication {

	public static void main(String[] args) {
		SpringApplication.run(VigalynMsUmApplication.class, args);
	}
}
