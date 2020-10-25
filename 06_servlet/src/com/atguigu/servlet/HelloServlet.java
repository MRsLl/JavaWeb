package com.atguigu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("1.构造器");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.初始化方法");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3.HelloServlet");
        HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
        String method = servletRequest1.getMethod();
        if ("GET".equals(method)){
            doGet();
        }else if ("POST".equals(method)){
            doPost();
        }
    }

    private void doPost() {
        System.out.println("post 请求的业务");
    }

    private void doGet() {
        System.out.println("get 请求的业务");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.销毁方法");
    }
}
