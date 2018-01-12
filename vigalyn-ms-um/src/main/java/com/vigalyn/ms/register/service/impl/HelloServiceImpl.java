package com.vigalyn.ms.register.service.impl;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vigalyn.hello.domain.User;
import com.vigalyn.hello.service.HelloService;

@RestController
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(@RequestParam("name") String name) {
        
        return "hello" + name;
    }

    @Override
    public User helloUser(@RequestParam("name") String userId) {

        return new User(userId,userId);
    }

}
