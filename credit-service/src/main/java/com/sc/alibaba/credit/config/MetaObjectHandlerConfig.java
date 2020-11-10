package com.sc.alibaba.credit.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MetaObjectHandlerConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        setFieldValByName("createTime", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), metaObject);
        setFieldValByName("deleted", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"), metaObject);
    }
}