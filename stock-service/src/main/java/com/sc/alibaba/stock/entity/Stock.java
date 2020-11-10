package com.sc.alibaba.stock.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 
 * 
 * @author wuhoujian
 * @email wuhoujian@126.com
 * @date 2020-11-06 14:04:56
 */
@TableName("s_stock")
@Data
public class Stock {
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
	 * 商品名称
	 */
	private String productName;
	/**
	 * 商品数量
	 */
	private Integer productNum;
	/**
	 * 商品价格
	 */
	private BigDecimal productPrice;
	/**
	 * 更新者
	 */
	private Long updateBy;
	/**
	 * 创建者
	 */
	private Long createBy;
}
