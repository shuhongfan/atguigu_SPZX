package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.product.ProductSku;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductSkuMapper {
    //添加
    void save(ProductSku productSku);

    //2 根据id查询商品sku信息列表  product_sku
    List<ProductSku> findProductSkuByProductId(Long id);

    //修改product_sku
    void updateById(ProductSku productSku);

    //2 根据商品id删除product_sku表
    void deleteByProductId(Long id);
}
