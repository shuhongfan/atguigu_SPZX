package com.atguigu.spzx.product.service;

import com.atguigu.spzx.model.entity.product.Category;

import java.util.List;

public interface CategoryService {
    //1 所有一级分类
    List<Category> selectOneCategory();

    //查询所有分类，树形封装
    List<Category> findCategoryTree();
}
