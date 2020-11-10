package com.sc.alibaba.stock.controller;

import com.sc.alibaba.stock.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class StockController {
    @Resource
    private StockService stockService;

    @PostMapping("/deduct")
    public String deduct(@RequestParam("stockId") Long stockId, @RequestParam("productNum") Integer productNum) {
        stockService.deduct(stockId, productNum);
        return "deduct stock success...";
    }
}
