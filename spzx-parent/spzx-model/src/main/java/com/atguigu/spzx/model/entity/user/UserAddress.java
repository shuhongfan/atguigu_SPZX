package com.atguigu.spzx.model.entity.user;

import com.atguigu.spzx.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户地址实体类")
public class UserAddress extends BaseEntity {

   private static final long serialVersionUID = 1L;

   @Schema(description = "用户ID")
   private Long userId;

   @Schema(description = "name")
   private String name;

   @Schema(description = "电话")
   private String phone;

   @Schema(description = "标签名称")
   private String tagName;

   @Schema(description = "provinceCode")
   private String provinceCode;

   @Schema(description = "cityCode")
   private String cityCode;

   @Schema(description = "districtCode")
   private String districtCode;

   @Schema(description = "详细地址")
   private String address;

   @Schema(description = "完整地址")
   private String fullAddress;

   @Schema(description = "是否默认地址（0：否 1：是）")
   private Integer isDefault;

}