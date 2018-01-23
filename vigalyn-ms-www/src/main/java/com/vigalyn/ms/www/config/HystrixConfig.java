package com.vigalyn.ms.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;

@Configuration
public class HystrixConfig {
    

        @Bean
        public Feign.Builder feignBuilder() {
            return Feign.builder();
        }
        
/*        @Bean
        public WwwHelloServiceHystrixImpl fb(){
            return new WwwHelloServiceHystrixImpl();
        }*/
        
}
