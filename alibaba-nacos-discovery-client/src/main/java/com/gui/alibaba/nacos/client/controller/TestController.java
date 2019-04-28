package com.gui.alibaba.nacos.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class TestController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/test")
    public String test() {
        // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("alibaba-nacos-discovery-server");
        //构造请求URL
        String url = serviceInstance.getUri() + "/hello?name=" + "william";

        //创建RestTemplate对象，通过Restful接口调用具体服务
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        return "Invoke : " + url + ", return : " + result;
    }
}
