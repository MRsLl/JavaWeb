package com.atguigu.dao;

import com.atguigu.pojo.Order;

import java.util.List;

public interface OrderDao {
    /**
     * 保存订单
     * @return
     */
    int saveOrder(Order order);

    /**
     * 根据用户编号查询订单
     * @param userId
     * @return
     */
    List<Order> queryOrdersByUserId(Integer userId);

    /**
     * 查询所有订单
     * @return
     */
    List<Order> queryOrders();

    /**
     * 修改指定订单的状态
     * @param orderId
     * @param status
     * @return
     */
    int changeOrderStatus(String orderId,Integer status);
}
