package com.vigalyn.ms.sso.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vigalyn.ms.sso.service.HelloService;

@RestController
@RequestMapping(value="/hello",produces= {"application/json;charset=UTF-8"})
//@RefreshScope
public class HelloController {
    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private HelloService wwwHelloService;
    
    @Value("${wind3.school}")
    String school = "桂平三中";
    
    @Value("${wind3.age}")
    String age = "20"; 
    
    @RequestMapping(value="/name",method=RequestMethod.GET)
    public String hello(@RequestParam String name) {
        LOG.info("sso begin hello " + name + ";school =" + school + ";age = " +age);
        return wwwHelloService.hello(name + school + age );
    }

}
