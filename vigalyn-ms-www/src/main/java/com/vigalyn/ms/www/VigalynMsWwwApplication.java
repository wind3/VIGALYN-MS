package com.vigalyn.ms.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
@SpringBootApplication  
@RefreshScope
public class VigalynMsWwwApplication {

	public static void main(String[] args) {
		SpringApplication.run(VigalynMsWwwApplication.class, args);
	}
}
