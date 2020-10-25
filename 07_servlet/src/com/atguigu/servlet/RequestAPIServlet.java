package com.atguigu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(value = "/requestAPIServlet")
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        i.	getRequestURI()					获取请求的资源路径
        System.out.println("资源路径" + request.getRequestURI());
//        ii.	getRequestURL()					获取请求的统一资源定位符( 绝对路径 )
        System.out.println("绝对路径" + request.getRequestURL());
//        iii.	getRemoteHost()				获取远程的主机 ( 客户端ip )
        System.out.println("客户端ip" + request.getRemoteHost());
//        iv.	getHeader()						获取请求头
        System.out.println("请求头" + request.getHeader("Host"));
//        v.	getParameter() 					获取请求的参数值
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        vi.	getParameterValues()				获取请求的参数值( 多个值的情况 )
        String[] hobby = request.getParameterValues("hobby");

        System.out.println("用户名：" + username +"密码：" + password + "兴趣爱好：" + Arrays.asList(hobby));
//        vii.	getMethod()					获取请求的方式GET或POST
        System.out.println("获取请求的方式：" + request.getMethod());
//        x.	getRequestDispatcher() 			获取请求转发对象.

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
