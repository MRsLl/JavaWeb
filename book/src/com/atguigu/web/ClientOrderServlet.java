package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/client/orderServlet")
public class ClientOrderServlet extends BaseServlet{
    private OrderService orderService = new OrderServiceImpl();

    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //2.获取用户对象并获取用户id
        User user = (User) request.getSession().getAttribute("user");
        //若用户 为空，则跳转到登录页面
        if (user == null){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
            return;
        }
        Integer id = user.getId();
        //3.创建订单
        String orderId = orderService.createOrder(id, cart);
        //4.把订单号存储到request 域中
        request.getSession().setAttribute("orderId",orderId);
        //5.转发到 /pages/cart/checkout.jsp 页面
        response.sendRedirect(request.getContextPath() + "/pages/cart/checkout.jsp");
    }
    protected void myOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户对象并获取用户id
        User user = (User) request.getSession().getAttribute("user");
        //若用户为空，则跳转到登录页面
        if (user == null){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
            return;
        }
        Integer id = user.getId();
        //2.根据用户id 获取用户的订单
        List<Order> orders = orderService.myOrder(id);
        //3.把用户的全部订单保存到request 域中
        request.setAttribute("orders",orders);
        //4.跳转到 pages/order/order.jsp 页面
        request.getRequestDispatcher("/pages/order/order.jsp").forward(request,response);
    }
    protected void receiveOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取订单号 orderId
        String orderId = request.getParameter("orderId");
        //2.调用 orderService 的receiveOrder() 方法完成确认收货
        orderService.receiveOrder(orderId);
        //3.使用重定向跳转回我的订单页面
        response.sendRedirect(request.getContextPath() + "/client/orderServlet?action=myOrder");
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
