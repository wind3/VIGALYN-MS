package com.vigalyn.ms.sso.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.vigalyn.ms.sso.service.WwwHelloService.WwwHelloServiceHystrixImpl;

@FeignClient(name="UmWeb",fallback = WwwHelloServiceHystrixImpl.class)
public class WwwHelloService implements HelloService{
  
    public String hello(String name) {
        return "hello hystrix circuit breakers work!";
    }
    
    class WwwHelloServiceHystrixImpl implements HelloService {

        @Override
        public String hello(String name) {
            return "hello hystrix circuit breakers work!";
        }


    }

}

