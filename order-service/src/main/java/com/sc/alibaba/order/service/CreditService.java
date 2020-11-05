package com.sc.alibaba.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 如果服务无法正常调用，为了系统的高可用，进行降级处理，执行fallback
 */
@FeignClient(value = "credit-service", fallback = CreditFallback.class)
public interface CreditService {
    @PostMapping("/addPoints")
    String addPoints();
}
