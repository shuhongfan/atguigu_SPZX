package com.atguigu.spzx.model.entity.system;

import com.atguigu.spzx.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "SysOperLog")
public class SysOperLog extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Schema(description = "模块标题")
	private String title;

	@Schema(description = "方法名称")
	private String method;

	@Schema(description = "请求方式")
	private String requestMethod;

	private Integer businessType ;			// 业务类型（0其它 1新增 2修改 3删除）

	@Schema(description = "操作类别（0其它 1后台用户 2手机端用户）")
	private String operatorType;

	@Schema(description = "操作人员")
	private String operName;

	@Schema(description = "请求URL")
	private String operUrl;

	@Schema(description = "主机地址")
	private String operIp;

	@Schema(description = "请求参数")
	private String operParam;

	@Schema(description = "返回参数")
	private String jsonResult;

	@Schema(description = "操作状态（0正常 1异常）")
	private Integer status;

	@Schema(description = "错误消息")
	private String errorMsg;

}