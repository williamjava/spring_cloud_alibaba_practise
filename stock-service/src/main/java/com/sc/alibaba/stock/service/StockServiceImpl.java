package com.sc.alibaba.stock.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.alibaba.stock.clients.StockService;
import com.sc.alibaba.stock.entity.Stock;
import com.sc.alibaba.stock.mapper.StockMapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存服务类
 */
@RestController
@Slf4j
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {
    /**
     * 扣减库存
     * @param stockId
     * @param productNum
     */
    @GlobalTransactional
    @Override
    public String deduct(Long stockId, Integer productNum) {
        System.out.println("扣减库存deduct开始...stockId=" + stockId + "，productNum=" + productNum);
        Stock stock = getBaseMapper().selectById(stockId);
        if (stock != null) {
            stock.setProductNum(stock.getProductNum() - productNum);
            getBaseMapper().updateById(stock);
        }

        return "success";
    }
}