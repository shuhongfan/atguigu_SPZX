package com.atguigu.spzx.model.entity.order;

import com.atguigu.spzx.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "订单日志实体对象")
public class OrderLog extends BaseEntity {

   private static final long serialVersionUID = 1L;

   @Schema(description = "订单id")
   private Long orderId;

   @Schema(description = "操作人：用户；系统；后台管理员")
   private String operateUser;

   @Schema(description = "订单状态")
   private Integer processStatus;

   @Schema(description = "备注")
   private String note;

}