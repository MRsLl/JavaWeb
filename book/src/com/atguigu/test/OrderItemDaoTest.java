package com.atguigu.test;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;


public class OrderItemDaoTest {
    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(1,"sss",100,new BigDecimal("10"),new BigDecimal("1000"),"1"));
    }

    @Test
    public void queryOrderItemByOrderId() {
        List<OrderItem> orderItems = orderItemDao.queryOrderItemsByOrderId("16003226214105");
        System.out.println(orderItems);
    }
}