package com.vigalyn.ms.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 单点登录系统
 *
 */

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class VigalynMsSsoApplication 
{
    public static void main(String[] args) {
        SpringApplication.run(VigalynMsSsoApplication.class, args);
    }
}
