package com.sc.alibaba.credit.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * 
 * @author wuhoujian
 * @email wuhoujian@126.com
 * @date 2020-11-06 14:15:30
 */
@TableName("c_credit")
@Data
public class Credit {
	@TableId(value="id", type= IdType.ASSIGN_ID)
	@JsonFormat(shape=JsonFormat.Shape.STRING)
	private Long id;
	@TableField(value="create_time", fill= FieldFill.INSERT)
	private String createTime;
	@TableField(value="update_time", fill=FieldFill.INSERT_UPDATE)
	private String updateTime;
	@TableField(value="is_deleted", fill=FieldFill.INSERT)
	private Integer deleted;

	private Long userId;
	/**
	 * 总积分
	 */
	private Integer totalScore;
	/**
	 * 更新者
	 */
	private Long updateBy;
	/**
	 * 创建者
	 */
	private Long createBy;
}
