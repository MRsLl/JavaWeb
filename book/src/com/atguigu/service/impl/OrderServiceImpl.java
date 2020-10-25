package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Integer userId, Cart cart) {
        //用系统时间 + 用户id 生成订单号
        String orderId = System.currentTimeMillis() + "" + userId;
        //用购物车的一些属性创建订单对象并保存
        orderDao.saveOrder(new Order(orderId,new Date(),cart.getTotalPrice(),0,userId));
        //遍历购物车中的购物车项，利用购物车项创建订单项并保存
        for (CartItem item : cart.getItems().values()) {
            OrderItem orderItem = new OrderItem(null,item.getName(),item.getCount(),item.getPrice(),
                    item.getTotalPrice(),orderId);

//            int i = 12/0;

            orderItemDao.saveOrderItem(orderItem);

            //修改图书的销量和库存
            Book book = bookDao.queryBook(item.getId());

            book.setSales(book.getSales() + orderItem.getCount());
            book.setStock(book.getStock() - orderItem.getCount());

            bookDao.updateBook(book);
        }

        //清空购物车
        cart.clear();



        return orderId;
    }

    @Override
    public List<Order> myOrder(Integer userId) {
        return orderDao.queryOrdersByUserId(userId);
    }

    @Override
    public void receiveOrder(String orderId) {
        orderDao.changeOrderStatus(orderId,2);
    }

    @Override
    public List<OrderItem> orderDetails(String orderId) {
        return orderItemDao.queryOrderItemsByOrderId(orderId);
    }

    @Override
    public List<Order> allOrders() {
        return orderDao.queryOrders();
    }

    @Override
    public void sendOrder(String orderId) {
        orderDao.changeOrderStatus(orderId,1);
    }
}
