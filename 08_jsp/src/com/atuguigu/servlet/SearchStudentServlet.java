package com.atuguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/searchStudentServlet")
public class SearchStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            studentList.add(new Student(i,"name" + i,"phone" + i,i%2));
        }
        request.setAttribute("stus",studentList);
        request.getRequestDispatcher("showStudent.jsp").forward(request,response);
    }
}
