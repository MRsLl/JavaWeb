package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @WebServlet 相当于
 *     <servlet>
 *         <servlet-name>Servlet2</servlet-name>
 *         <servlet-class>com.atguigu.servlet.Servlet5</servlet-class>
 *     </servlet>
 *
 * value="/servlet2" 相当于以下配置:
 *     <servlet-mapping>
 *         <servlet-name>Servlet2</servlet-name>
 *         <url-pattern>/servlet2</url-pattern>
 *     </servlet-mapping>
 */
@WebServlet(value = "/servlet2")
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet2 doPost()");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet2 doGet()");
    }
}
