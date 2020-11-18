package com.sc.ali.dubbo.consumer.controller;

import com.sc.ali.dubbo.api.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{
    @Reference
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello(String name) {
        return helloService.hello(name);
    }
}
