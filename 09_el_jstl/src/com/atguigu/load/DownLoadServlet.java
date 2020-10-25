package com.atguigu.load;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet(value = "/downLoadServlet")
public class DownLoadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String filename = request.getParameter("filename");
        //1.读取客户端要下载的文件
        ServletContext servletContext = getServletContext();

        //获取指定路径的 MIME 类型/数据类型
        String mimeType = servletContext.getMimeType("/file/" + filename);
        //3.告诉客户端要接收的文件数据类型是什么
        response.setContentType(mimeType);
        //4.告诉客户端收到的数据用于下载
        response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode("景色.jpg","utf-8"));
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + filename);
        //2.通过响应流写给客户端
        ServletOutputStream outputStream = response.getOutputStream();
        //把输入流中的数据完全写到输出流中
        IOUtils.copy(resourceAsStream,outputStream);
        resourceAsStream.close();
    }
}
