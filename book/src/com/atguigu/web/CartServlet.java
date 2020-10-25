package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/cartServlet")
public class CartServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //2.如果购物车非空，则清空购物车
        if (cart != null) {
            cart.clear();
            //3.重定向回购物车页面
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        Integer count = WebUtils.parseInt(request.getParameter("count"), 1);
        //2.获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            //3.调用 cart.updateCount();
            cart.updateCount(id,count);
            //4.重定向回购物车页面
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        //2.获取购物车对象cart
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        //3.调用cart 的deleteItem(id);
        cart.deleteItem(id);
        //4.重定向到购物车页面
        response.sendRedirect(request.getHeader("Referer"));
    }
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        //2.根据id 查书
        Book book = bookService.queryBookById(id);
        //3.把book 转换为 cartItem
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //4.获取Cart 购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        //5.向购物车中添加
        cart.addItem(cartItem);
        //将最后加入的那本书的书名存入session 域中
        request.getSession().setAttribute("lastName",cartItem.getName());
        //6.重定向回首页
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void ajaxAddItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取参数
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        //2.根据id 查书
        Book book = bookService.queryBookById(id);
        //3.把book 转换为 cartItem
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        //4.获取Cart 购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        //5.向购物车中添加
        cart.addItem(cartItem);
        //将最后加入的那本书的书名存入session 域中
        request.getSession().setAttribute("lastName",cartItem.getName());

        Map<String,Object> map = new HashMap<>();
        map.put("cartTotalCount",cart.getTotalCount());
        map.put("cartLastName",cartItem.getName());

        Gson gson = new Gson();

        response.getWriter().write(gson.toJson(map));
    }
}
