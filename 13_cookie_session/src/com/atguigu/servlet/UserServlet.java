package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/userServlet")
public class UserServlet extends BaseServlet {

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.比较用户名和密码是否正确
        if ("zhangsan".equals(username) && "12345".equals(password)){
            System.out.println("登录成功");
            Cookie cookie = new Cookie("username",username);
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
        } else {
            System.out.println("登录失败");
        }
    }
}
