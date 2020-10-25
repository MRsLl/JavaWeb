package com.atguigu.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/servlet1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        =============================域对象=====================================
//        viii.	setAttribute(key, value);	保存域数据
//        ix.	getAttribute(key); 		获取域数据
//      =========================================================================
        System.out.println("柜台一查看材料："+request.getParameter("username"));
        request.setAttribute("key","柜台1盖章");
        //获取转发对象
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");
        requestDispatcher.forward(request,response);
    }
}
