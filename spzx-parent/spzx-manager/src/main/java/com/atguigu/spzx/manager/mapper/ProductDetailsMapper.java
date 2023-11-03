package com.atguigu.spzx.manager.mapper;

import com.atguigu.spzx.model.entity.product.ProductDetails;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDetailsMapper {

    //添加
    void save(ProductDetails productDetails);

    //3 根据id删除商品详情数据 product_details
    ProductDetails findProductDetailsById(Long id);

    //修改product_details
    void updateById(ProductDetails productDetails);

    //3 根据商品id删除product_details表
    void deleteByProductId(Long id);
}
