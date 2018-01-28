package com.vigalyn.ms.www;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
@SpringBootApplication  
@RefreshScope
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class VigalynMsWwwApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(VigalynMsWwwApplication.class, args);
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
          
	}
}
