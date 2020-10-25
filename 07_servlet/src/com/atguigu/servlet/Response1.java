package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/response1")
public class Response1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("response1: 我已废弃");

        /*//方案1 设置响应码和响应头
        response.setStatus(302);
        response.setHeader("location","http://localhost:8080/07_servlet/response2");*/

        //方案2：重定向
        response.sendRedirect("http://localhost:8080/07_servlet/response2");
//        response.sendRedirect("http://baidu.com");
    }
}
