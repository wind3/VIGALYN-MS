package com.vigalyn.ms.www.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import com.vigalyn.hello.domain.User;
import com.vigalyn.hello.service.HelloService;
import com.vigalyn.ms.www.service.WwwHelloService.HelloHystrixFactory;

import feign.hystrix.FallbackFactory;

//@FeignClient(name="UmWeb",fallback = WwwHelloServiceHystrixImpl.class,configuration=HystrixConfig.class)
@FeignClient(name="UmWeb",fallbackFactory = HelloHystrixFactory.class)
public interface WwwHelloService extends HelloService {

    /*static class WwwHelloServiceHystrixImpl implements HelloService {

        @Override
        public String hello(String name) {
            return "hello hystrix circuit breakers work!";
        }

        @Override
        public User hello(String name, Integer age) {
            return null;
        }

        @Override
        public String hello(User user) {
            return "hello User : " + user.toString()+",hystrix circuit breakers work!";
        }

    }*/
    
    @Component  
    static class HelloHystrixFactory implements FallbackFactory<WwwHelloService>{
            private static final Logger logger = LoggerFactory.getLogger(HelloHystrixFactory.class);  
            @Override  
            public WwwHelloService create(Throwable cause) {  
                logger.info("fallback reason was: {} " ,cause.getMessage());  
                  
                return new WwwHelloServiceFallBack(){  
                    @Override
                    public String hello(String name) {
                        return "hello hystrix circuit breakers work!";
                    }

                    @Override
                    public User hello(String name, Integer age) {
                        return null;
                    }

                    @Override
                    public String hello(User user) {
                        return "hello User : " + user.toString()+",hystrix circuit breakers work!";
                    }

            };
            }}}
