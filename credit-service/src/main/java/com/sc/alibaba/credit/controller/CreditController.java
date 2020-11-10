package com.sc.alibaba.credit.controller;

import com.sc.alibaba.credit.service.CreditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CreditController {
    @Resource
    private CreditService creditService;

    @PostMapping("/addPoints")
    public String addPoints(@RequestParam(value = "userId", required = false) Long userId, @RequestParam("points") Integer points) {
        creditService.addPoints(userId == null ? 1L : userId, points);

        return "add points success...";
    }
}
