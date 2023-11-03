package com.atguigu.spzx.product.service;

import com.atguigu.spzx.model.entity.product.Brand;

import java.util.List;

public interface BrandService {

    //获取全部品牌
    List<Brand> findAll();
}
