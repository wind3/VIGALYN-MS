package com.vigalyn.ms.um.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vigalyn.hello.domain.User;
import com.vigalyn.hello.service.HelloService;

@RestController
public class HelloServiceImpl implements HelloService {
    private static final Logger LOG = LoggerFactory.getLogger(HelloServiceImpl.class);
    @Override
    public String hello(@RequestParam("name") String name) {
        LOG.info("实例2" + name);
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
