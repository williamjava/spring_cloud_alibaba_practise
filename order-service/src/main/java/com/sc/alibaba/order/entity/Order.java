package com.sc.alibaba.order.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 
 * 
 * @author wuhoujian
 * @email wuhoujian@126.com
 * @date 2020-11-06 13:57:52
 */
@TableName("o_order")
@Data
public class Order {
	@TableId(value="id", type= IdType.ASSIGN_ID)
	@JsonFormat(shape=JsonFormat.Shape.STRING)
	private Long id;
	@TableField(value="create_time", fill= FieldFill.INSERT)
	private String createTime;
	@TableField(value="update_time", fill=FieldFill.INSERT_UPDATE)
	private String updateTime;
	@TableField(value="is_deleted", fill=FieldFill.INSERT)
	private Integer deleted;

	/**
	 * 
	 */
	private Long userId;
	/**
	 * 订单单号
	 */
	private String orderNo;
	/**
	 * 库存ID
	 */
	private Long stockId;
	/**
	 * 数量
	 */
	private Integer stockNum;
	/**
	 * 价格
	 */
	private BigDecimal totalPrice;
	/**
	 * 更新者
	 */
	private Long updateBy;
	/**
	 * 创建者
	 */
	private Long createBy;
}
