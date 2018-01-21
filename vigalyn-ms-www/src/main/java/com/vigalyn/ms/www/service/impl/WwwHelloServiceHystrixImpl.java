package com.vigalyn.ms.www.service.impl;

import com.vigalyn.hello.domain.User;
import com.vigalyn.hello.service.HelloService;

public class WwwHelloServiceHystrixImpl implements HelloService {

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

}
