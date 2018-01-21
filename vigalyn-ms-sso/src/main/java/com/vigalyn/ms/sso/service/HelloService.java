package com.vigalyn.ms.sso.service;

import org.springframework.web.bind.annotation.RequestParam;


public interface HelloService {


    String hello(@RequestParam("name") String name);
 


}
