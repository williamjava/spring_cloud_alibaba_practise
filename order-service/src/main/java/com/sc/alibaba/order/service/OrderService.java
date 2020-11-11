package com.sc.alibaba.order.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.alibaba.order.entity.Order;
import com.sc.alibaba.order.mapper.OrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 订单服务类
 */
@Service
@Slf4j
public class OrderService extends ServiceImpl<OrderMapper, Order> {
    @Resource
    private StockService stockService;
    @Resource
    private CreditService creditService;

    /**
     * 创建订单
     * @param userId
     * @param stockId
     * @param productNum
     * @param totalPrice
     */
    @GlobalTransactional
    public void create(Long userId, Long stockId, Integer productNum, BigDecimal totalPrice) {
        //1.创建订单
        addOrder(userId, stockId, productNum, totalPrice);

        //2.扣减库存
        stockService.deduct(stockId, productNum);

        //3.增加积分, 默认加5分
        creditService.addPoints(userId, 5);
    }

    private void addOrder(Long userId, Long stockId, Integer productNum, BigDecimal totalPrice) {
        System.out.println("创建订单addOrder开始...userId=" + userId + "，stockId=" + stockId + "，productNm=" + productNum + "，totalPrice=" + totalPrice);
        Order order = new Order();
        order.setUserId(userId);
        order.setOrderNo(String.valueOf(System.currentTimeMillis()));
        order.setStockId(stockId);
        order.setStockNum(productNum);
        order.setTotalPrice(totalPrice);
        this.baseMapper.insert(order);
    }
}