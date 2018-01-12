package com.vigalyn.ms.www.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.vigalyn.hello.service.HelloService;

@FeignClient(value="UmWeb")
public interface WwwHelloService extends HelloService {

}
