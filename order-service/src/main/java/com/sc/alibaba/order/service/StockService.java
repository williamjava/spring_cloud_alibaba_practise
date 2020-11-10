package com.sc.alibaba.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("stock-service")
public interface StockService {
    @PostMapping("/deduct")
    String deduct(@RequestParam("stockId") Long stockId, @RequestParam("productNum") Integer productNum);
}
