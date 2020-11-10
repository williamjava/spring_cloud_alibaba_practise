package com.sc.alibaba.credit.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.alibaba.credit.entity.Credit;
import com.sc.alibaba.credit.mapper.CreditMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 积分服务类
 */
@Service
@Slf4j
public class CreditService extends ServiceImpl<CreditMapper, Credit> {
    /**
     * 增加积分
     * @param userId
     * @param points
     */
    public void addPoints(Long userId, Integer points) {
        System.out.println("增加积分addPoints开始...userId=" + userId + "，points=" + points);
        List<Credit> creditList = getBaseMapper().selectList(new LambdaQueryWrapper<Credit>().eq(Credit::getUserId, userId));
        if (CollectionUtils.isEmpty(creditList)) {
            Credit credit = new Credit();
            credit.setUserId(userId);
            credit.setTotalScore(points);
            getBaseMapper().insert(credit);
        } else {
            Credit credit = creditList.get(0);
            credit.setTotalScore(credit.getTotalScore() + points);
            getBaseMapper().updateById(credit);
        }
    }
}