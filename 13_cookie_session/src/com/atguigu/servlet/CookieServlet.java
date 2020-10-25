package com.atguigu.servlet;

import com.atguigu.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/cookieServlet")
public class CookieServlet extends BaseServlet {
    protected void testPath(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = utf-8");
        Cookie cookie = new Cookie("t1","t1Path");
        // path值默认是当前工程路径
        // 设置path值为 : /13_cookie_session/abc
        System.out.println(cookie.getPath());
        cookie.setPath(request.getContextPath() + "/abc");
        System.out.println(cookie.getPath());

        response.addCookie(cookie);
        response.getWriter().write("创建一个自定义 path 的 cookie");
    }
    protected void life3600(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("k5","v5");
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        response.getWriter().write("设置了一个能存活一小时的 cookie 对象");
    }
    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.通过名字找到相应 cookie
        Cookie cookie = CookieUtils.findCookie(request.getCookies(),"k2");
        //2.设置该cookie 的存活时间为0，即不等浏览器关闭就删除
        cookie.setMaxAge(0);
        //3.通知客户端保存cookie 对象
        response.addCookie(cookie);
        response.getWriter().write("立刻删除名为" + cookie.getName() + "的 cookie 对象");
    }
    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("k4","v4");
        cookie.setMaxAge(-1);//设置一个在浏览器关闭后就会删除的 cookie
        response.addCookie(cookie);
        response.getWriter().write("设置了一个默认存活时间的 cookie");
    }

    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //方案1：创建一个新的同名 cookie 对象，通知客户端
        //1.创建一个新的同名 cookie 对象,并在构造器中赋新值
        Cookie cookie1 = new Cookie("k3","newV3");
        //2.通知客户端保存cookie 对象
        response.addCookie(cookie1);

        //方案2：通过 Cookie 对象的 setValue() 方法修改
        //1.通过cookie 的名字获取指定cookie
        Cookie cookie2 = CookieUtils.findCookie(request.getCookies(),"k2");
        //2.通过 Cookie 对象的 setValue() 方法给 cookie 对象赋值
        cookie2.setValue("newV2");
        //3.通知客户端保存cookie 对象
        response.addCookie(cookie2);

    }

    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        //1.获取所有 cookie 对象
        Cookie[] cookies = request.getCookies();

        //2.遍历输出所有获取到的 cookie 对象
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                response.getWriter().write(" 服务器收到cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br/>");
            }
        }

        //3.通过cookie 的名字获取指定cookie
        String name = "k2";
        Cookie cookie = CookieUtils.findCookie(cookies, name);

        if (cookie != null) {
            response.getWriter().write(" 找到我想要的cookie" + cookie.getName() + "=" + cookie.getValue());
        }

    }

    protected void createCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的字符集
        response.setContentType("text/html; charset=UTF-8");

        //1.创建cookie对象
        Cookie cookie1 = new Cookie("k3", "v3");
        Cookie cookie2 = new Cookie("k2", "v2");

        //2.添加到response 对象中
        response.addCookie(cookie1);
        response.addCookie(cookie2);

        response.getWriter().write(cookie1.getName());
        response.getWriter().write("cookie已经创建好");
    }
}
