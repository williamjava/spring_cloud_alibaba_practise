package com.sc.alibaba.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("stock-service")
public interface StockService {
    @PostMapping("/deduct")
    String deduct();
}
