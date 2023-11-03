package com.atguigu.spzx.cart.service;

import com.atguigu.spzx.model.entity.h5.CartInfo;

import java.util.List;

public interface CartService {

    //添加购物车
    void addToCart(Long skuId, Integer skuNum);

    //查询购物车
    List<CartInfo> getCartList();

    //删除购物车商品
    void deleteCart(Long skuId);

    //更新购物车商品选中状态
    void checkCart(Long skuId, Integer isChecked);

    //更新购物车商品全部选中状态
    void allCheckCart(Integer isChecked);

    //清空购物车
    void clearCart();

    //远程调用：订单结算使用，获取购物车选中商品列表
    List<CartInfo> getAllCkecked();

    //远程调用：删除生成订单的购物车商品
    void deleteChecked();
}
