package com.atguigu.test;


import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;


public class OrderServiceTest {
    OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1,"笔记本",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(2,"手机",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"手机",1,new BigDecimal(1000),new BigDecimal(1000)));

        orderService.createOrder(5,cart);

        System.out.println(cart);
    }

    @Test
    public void myOrder() {
        List<Order> orders = orderService.myOrder(5);
        System.out.println(orders);
    }

    @Test
    public void receiveOrder() {
        orderService.receiveOrder("16003226214105");
    }

    @Test
    public void orderDetails() {
        List<OrderItem> orderItems = orderService.orderDetails("16003226214105");
        System.out.println(orderItems);
    }

    @Test
    public void allOrders() {
        List<Order> orders = orderService.allOrders();
        System.out.println(orders);
    }

    @Test
    public void sendOrder() {
        orderService.sendOrder("16003226214105");
    }
}