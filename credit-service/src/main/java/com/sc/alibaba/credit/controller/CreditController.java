package com.sc.alibaba.credit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CreditController {
    @PostMapping("/addPoints")
    public String addPoints() {
        System.out.println("add points success");
        return "add points success...";
    }
}
