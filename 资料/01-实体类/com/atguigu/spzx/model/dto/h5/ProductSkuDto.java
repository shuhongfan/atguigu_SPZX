package com.atguigu.spzx.model.dto.h5;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "商品列表搜索条件实体类")
public class ProductSkuDto {

    @Schema(description = "关键字")
    private String keyword;

    @Schema(description = "品牌id")
    private Long brandId;

    @Schema(description = "一级分类id")
    private Long category1Id;

    @Schema(description = "二级分类id")
    private Long category2Id;

    @Schema(description = "三级分类id")
    private Long category3Id;

    @Schema(description = "排序（综合排序:1 价格升序:2 价格降序:3）")
    private Integer order = 1;

}