package com.atguigu.spzx.manager.task;

import cn.hutool.core.date.DateUtil;
import com.atguigu.spzx.manager.mapper.OrderInfoMapper;
import com.atguigu.spzx.manager.mapper.OrderStatisticsMapper;
import com.atguigu.spzx.model.entity.order.OrderStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrderStatisticsTask {

    // 注解：@Scheduled + cron表达式
    //cron表达式设置执行规则
    //测试定时任务
    //每隔5s，方法执行一次
//    @Scheduled(cron = "0/5 * * * * ? ")
//    public void testHello() {
//        System.out.println(new Date().toInstant());
//    }

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private OrderStatisticsMapper orderStatisticsMapper;

    //每天凌晨2点，查询前一天日期统计数据，把统计之后数据添加统计结果表里面
    @Scheduled(cron = "0 0 2 * * ?")
    //@Scheduled(cron = "0/10 * * * * ? ") //TODO 为了测试
    public void orderTotalAmountStatistics() {
        System.out.println(new Date().toInstant());
        //1 获取前一天日期
        String createDate =
                DateUtil.offsetDay(new Date(), -1).toString("yyyy-MM-dd");

        //2 根据前一天日期进行统计功能，（分组操作）
        //统计前一天交易金额
        OrderStatistics orderStatistics =
                orderInfoMapper.selectStatisticsByDate(createDate);

        //3 把统计之后的数据，添加统计结果表里面
        if(orderStatistics != null) {
            orderStatisticsMapper.insert(orderStatistics);
        }

    }

}
