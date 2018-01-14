package com.vigalyn.ms.www.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vigalyn.hello.domain.User;
import com.vigalyn.ms.www.service.WwwHelloService;

@RestController
@RequestMapping(value="/hello",produces= {"application/json;charset=UTF-8"})
@RefreshScope
public class HelloController {
    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private WwwHelloService wwwHelloService;
    
    @Value("${wind3:age}")
    String school = "桂平三中";
    
    @RequestMapping(value="/name",method=RequestMethod.GET)
    public String hello(@RequestParam String name) {
        LOG.info("begin hello " + name + ";school =" + school);
        return wwwHelloService.hello(name + school);
    }
    
    @RequestMapping(value="/user",method=RequestMethod.GET)
    public String helloUser(@RequestBody User user) {
        LOG.info("begin hello " + user.toString());
        return wwwHelloService.hello(user);
    }
}
