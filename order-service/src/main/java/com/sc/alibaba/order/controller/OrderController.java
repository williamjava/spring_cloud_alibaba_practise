package com.sc.alibaba.order.controller;

import com.alibaba.fastjson.JSON;
import com.sc.alibaba.order.service.CreditService;
import com.sc.alibaba.order.service.OrderService;
import com.sc.alibaba.order.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

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

    @Resource
    private OrderService orderService;

    /**
     * restTemplate.postForObject("http://stock-service/deduct", null, String.class);
     *
     * restTemplate.postForObject("http://credit-service/addPoints", null, String.class);
     *
     * @return
     */
    @GetMapping("/create")
    public String create(@RequestParam("stockId") Long stockId, @RequestParam("num") Integer num, @RequestParam("price") BigDecimal price) {
        orderService.create(1L, stockId, num, price);
        return "create order success...";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, my name is " + name;
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id) {
        return JSON.toJSONString(orderService.getById(id));
    }
}
