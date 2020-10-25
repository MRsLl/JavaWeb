package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/sessionServlet")
public class SessionServlet extends BaseServlet {
    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = utf-8");
        request.getSession().invalidate();
        response.getWriter().write("立刻销毁一个session 对象");
    }
    protected void life3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = utf-8");
        //把一个session 对象的超时时长设置为三秒
        request.getSession().setMaxInactiveInterval(3);
        response.getWriter().write("session 将在三秒后销毁");
    }
    protected void defaultLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = utf-8");
        //获取session 对象的最长存活时间
        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
        response.getWriter().write("一个session 对象超时时长是" + maxInactiveInterval +"s");
    }
    protected void getAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = utf-8");
        //1.获取或创建session 对象
        HttpSession session = request.getSession();
        //2.从session 域中获取随机生成的数字
        Object num =  session.getAttribute("num");
        response.getWriter().write("从session 中获取的随机数为" + num);
    }
    protected void setAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = utf-8");
        //1.获取或创建session 对象
        HttpSession session = request.getSession();
        //2.随机生成一个数字
        double i = 100 * Math.random();
        //3.将随机数存入session 域中
        session.setAttribute("num",i);
        response.getWriter().write("随机生成的数字是" + i);
    }
    protected void createOrGetSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset = utf-8");
        //创建或获得session 对象
        HttpSession session = request.getSession();
        //验证是否是第一次获取
        boolean isNew = session.isNew();
        //获取session 的 id
        String id = session.getId();

        response.getWriter().write("验证是否是第一次获取session 对象" + isNew);
        response.getWriter().write("session 的id 是" + id);
    }
}
