package com.atguigu.spzx.order.mapper;

import com.atguigu.spzx.model.entity.order.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderInfoMapper {

    //添加数据到order_info表
    void save(OrderInfo orderInfo);

    //获取订单信息
    OrderInfo getById(Long orderId);

    //根据userId 和 订单状态查询
    List<OrderInfo> findUserPage(Long userId, Integer orderStatus);

    //远程调用：根据订单编号获取订单信息
    OrderInfo getOrderInfoByOrderNo(String orderNo);

    //更新订单状态
    void updateById(OrderInfo orderInfo);
}
