package com.sc.alibaba.order.controller;

import com.sc.alibaba.order.service.CreditService;
import com.sc.alibaba.order.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RefreshScope
public class OrderController {
    @Value("${author.name}")
    private String name;

    @Resource
    private StockService stockService;
    @Resource
    private CreditService creditService;

    /**
     * restTemplate.postForObject("http://stock-service/deduct", null, String.class);
     *
     * restTemplate.postForObject("http://credit-service/addPoints", null, String.class);
     *
     * @return
     */
    @GetMapping("/create")
    public String create() {
        /**
         * 扣减库存
         */
        stockService.deduct();
        /**
         * 加积分
         */
        creditService.addPoints();

        return "create order success...";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, my name is " + name;
    }
}
