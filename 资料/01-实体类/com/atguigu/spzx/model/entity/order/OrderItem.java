package com.atguigu.spzx.model.entity.order;

import com.atguigu.spzx.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Schema(description = "订单项实体类")
public class OrderItem extends BaseEntity {

   private static final long serialVersionUID = 1L;

   @Schema(description = "订单id")
   private Long orderId;

   @Schema(description = "商品sku编号")
   private Long skuId;

   @Schema(description = "商品sku名字")
   private String skuName;

   @Schema(description = "商品sku图片")
   private String thumbImg;

   @Schema(description = "商品sku价格")
   private BigDecimal skuPrice;

   @Schema(description = "商品购买的数量")
   private Integer skuNum;

}