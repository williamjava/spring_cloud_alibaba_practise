package com.sc.alibaba.stock.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StockController {
    @PostMapping("/deduct")
    public String deduct() {
        System.out.println("deduct stock success");
        return "deduct stock success...";
    }
}
