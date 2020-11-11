package com.sc.alibaba.stock.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.alibaba.stock.entity.Stock;
import com.sc.alibaba.stock.mapper.StockMapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 库存服务类
 */
@Service
@Slf4j
public class StockService extends ServiceImpl<StockMapper, Stock> {
    /**
     * 扣减库存
     * @param stockId
     * @param productNum
     */
    @GlobalTransactional
    public void deduct(Long stockId, Integer productNum) {
        System.out.println("扣减库存deduct开始...stockId=" + stockId + "，productNum=" + productNum);
        Stock stock = getBaseMapper().selectById(stockId);
        if (stock != null) {
            stock.setProductNum(stock.getProductNum() - productNum);
            getBaseMapper().updateById(stock);
        }
    }
}