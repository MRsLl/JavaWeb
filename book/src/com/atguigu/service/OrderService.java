package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    /**
     * 生成订单
     * @param userId
     * @param cart
     * @return
     */
    String createOrder(Integer userId, Cart cart);

    /**
     * 我的订单
     * @param userId
     * @return
     */
    List<Order> myOrder(Integer userId);

    /**
     * 确认收货
     * @param orderId
     * @return
     */
    void receiveOrder(String orderId);

    /**
     * 订单明细，详情
     * @param orderId
     * @return
     */
    List<OrderItem> orderDetails(String orderId);

    /**
     * 查询所有订单
     * @return
     */
    List<Order> allOrders();

    /**
     * 确认发货
     * @param orderId
     * @return
     */
    void sendOrder(String orderId);
}
