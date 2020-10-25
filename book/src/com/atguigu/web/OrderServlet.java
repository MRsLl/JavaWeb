package com.atguigu.web;

import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/manager/orderServlet")
public class OrderServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();

    protected void allOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用 orderService 的 allOrders() 方法获取所有订单信息
        List<Order> orders = orderService.allOrders();
        //2.把所有订单信息存入request 域中
        request.setAttribute("orders",orders);
        //3.转发到 /pages/manager/order_manager.jsp 页面
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request,response);
    }
    protected void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取订单号 orderId
        String orderId = request.getParameter("orderId");
        //2.调用 orderService 的receiveOrder() 方法完成确认收货
        orderService.sendOrder(orderId);
        //3.使用重定向跳转回订单管理页面
        response.sendRedirect(request.getContextPath() + "/manager/orderServlet?action=allOrders");
    }

    protected void orderDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取订单号 orderId
        String orderId = request.getParameter("orderId");
        //2.调用orderService 的 orderDetails() 方法获取订单项列表
        List<OrderItem> orderItems = orderService.orderDetails(orderId);
        //3.把订单项列表保存到 request域中
        request.setAttribute("orderItems",orderItems);
        //4.跳转到 pages/order/order_details.jsp 页面
        request.getRequestDispatcher("/pages/order/order_details.jsp").forward(request,response);
    }
}
