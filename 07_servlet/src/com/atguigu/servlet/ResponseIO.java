package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/responseIO")
public class ResponseIO extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*// 设置服务器使用的字符集为UTF-8
        response.setCharacterEncoding("UTF-8");
        // 通过设置响应头,让客户端使用UTF-8字符集.
        response.setHeader("Content-Type","text/html; charset=utf-8");*/

        // 同时设置客户端和服务器都使用UTF-8
        // 必须在获取流之前调用才有效
        response.setContentType("utf-8");

        PrintWriter writer = response.getWriter();

        //writer.write("你好啊");
        writer.print("你好啊");
        writer.print("hello啊");
    }
}
