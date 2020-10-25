package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public class OrderDaoTest {
    OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("2",new Date(20200914),new BigDecimal("1000"),2,2));
    }

    @Test
    public void queryOrdersByUserId() {
        List<Order> orders = orderDao.queryOrdersByUserId(5);
        System.out.println(orders);
    }

    @Test
    public void queryOrders() {
        List<Order> orders = orderDao.queryOrders();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void changeOrderStatus() {
        orderDao.changeOrderStatus("1",100);
    }
}