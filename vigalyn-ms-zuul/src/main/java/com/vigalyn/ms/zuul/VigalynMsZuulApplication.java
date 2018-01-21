package com.vigalyn.ms.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@RefreshScope
public class VigalynMsZuulApplication 
{
    public static void main(String[] args) {
        SpringApplication.run(VigalynMsZuulApplication.class, args);
    }
}
