package com.sc.alibaba.stock.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("stock-service")
public interface StockService {
    @GetMapping("/deduct")
    String deduct(@RequestParam("stockId") Long stockId, @RequestParam("productNum") Integer productNum);
}
