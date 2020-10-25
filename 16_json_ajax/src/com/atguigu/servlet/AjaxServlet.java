package com.atguigu.servlet;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(value = "/ajaxServlet")
public class AjaxServlet extends BaseServlet{

    protected void javaScriptAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("javaScriptAjax 调用了");
        Person person = new Person(1,"张三");

        Gson gson = new Gson();
        String s = gson.toJson(person);
        response.getWriter().write(s);

    }
    protected void jQueryAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQueryAjax 调用了");
        Person person = new Person(1,"张三");

        Gson gson = new Gson();
        String s = gson.toJson(person);
        response.getWriter().write(s);
    }


    protected void jQueryGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQueryGet 调用了");
        Person person = new Person(2,"李四");

        Gson gson = new Gson();
        String s = gson.toJson(person);
        response.getWriter().write(s);
    }

    protected void jQueryPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQueryPost 调用了");
        Person person = new Person(3,"王二");

        Gson gson = new Gson();
        String s = gson.toJson(person);
        response.getWriter().write(s);
    }

    protected void jQueryGetJSON(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jQueryGetJSON 调用了");
        Person person = new Person(4,"刘大");

        Gson gson = new Gson();
        String s = gson.toJson(person);
        response.getWriter().write(s);
    }

    protected void jQuerySerialize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(" jQuerySerialize () 调用了 ");

        System.out.println("下拉单选 => " + request.getParameter("single"));
        System.out.println( "筛选 => " + Arrays.asList(request.getParameterValues("check")) );
        System.out.println("用户名=>" + request.getParameter("username"));
        System.out.println("密码=>" + request.getParameter("password"));


        Person person = new Person(1, "jQuerySerialize");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        response.getWriter().write(s);
    }
}

