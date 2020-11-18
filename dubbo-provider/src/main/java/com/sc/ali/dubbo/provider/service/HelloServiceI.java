package com.sc.ali.dubbo.provider.service;

import com.sc.ali.dubbo.api.HelloService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class HelloServiceI implements HelloService {
    @Override
    public String hello(String s) {
        return "Hello, " + s + "，welcome....";
    }
}
