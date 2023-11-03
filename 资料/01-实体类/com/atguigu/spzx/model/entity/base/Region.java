package com.atguigu.spzx.model.entity.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "区域实体类")
public class Region extends BaseEntity {

	@Schema(description = "区域编码")
	private String code;

	@Schema(description = "父区域编码")
	private Long parentCode;

	@Schema(description = "父区名称")
	private String name;

	@Schema(description = "地区级别：1-省、自治区、直辖市 2-地级市、地区、自治州、盟 3-市辖区、县级市、县")
	private Integer level;

}