package com.atguigu.spzx.model.entity.system;

import com.atguigu.spzx.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "系统用户实体类")
public class SysUser extends BaseEntity {

	@Schema(description = "用户名")
	private String userName;

	@Schema(description = "密码")
	private String password;

	@Schema(description = "昵称")
	private String name;

	@Schema(description = "手机号码")
	private String phone;

	@Schema(description = "图像")
	private String avatar;

	@Schema(description = "描述")
	private String description;

	@Schema(description = "状态（1：正常 0：停用）")
	private Integer status;

}