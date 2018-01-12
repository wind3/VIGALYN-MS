package com.vigalyn.ms.register.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vigalyn.hello.domain.User;
import com.vigalyn.hello.service.HelloService;

@RestController
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(@RequestParam("name") String name) {
        return "hello " + name;
    }
 
    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        try {
            name= URLDecoder.decode(name,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new User(name, age);
    }
 
    @Override
    public String hello(@RequestBody User user) {
        if (user == null) {
            return "未知";
        }
        return user.toString();
    }

}
