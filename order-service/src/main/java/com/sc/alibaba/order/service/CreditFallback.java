package com.sc.alibaba.order.service;

import org.springframework.stereotype.Component;

@Component
public class CreditFallback implements CreditService {

    @Override
    public String addPoints(Long userId, Integer points) {
        System.out.println("addPoints无法调用，进行降级处理，记录日志...");
        return "add points fallback";
    }
}
