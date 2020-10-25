package com.atguigu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/servlet4")
public class Servlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        //1.获取在web.xml中配置的上下文参数 context-param 标签
        System.out.println("context-param username =>" + servletContext.getInitParameter("root"));
        System.out.println("context-param password =>" + servletContext.getInitParameter("password"));

        //2.获取web工程的工程路径
        System.out.println("工程路径" + servletContext.getContextPath());

        //3.获取web部署到服务器之后，在服务器硬盘上的绝对路径
        System.out.println(servletContext.getRealPath("/"));
        System.out.println(servletContext.getRealPath("/test.html"));
        System.out.println(servletContext.getRealPath("/index.html"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
