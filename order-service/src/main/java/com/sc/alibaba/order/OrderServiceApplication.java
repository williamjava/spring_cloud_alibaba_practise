package com.sc.alibaba.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 使用Fegin调用服务，开启注解EnableFeignClients
 *
 * 使用sentinel进行服务的流量控制和熔断(打到一定错误比例就不调用服务，一定时间周期之后重新调用)
 */
@SpringBootApplication(scanBasePackages = {"com.sc.alibaba.order.*"})
@EnableFeignClients
public class OrderServiceApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
