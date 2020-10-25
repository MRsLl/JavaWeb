package com.atguigu.load;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/loadServlet")
public class LoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 判断是否是多段的数据格式提交 multipart/form-data
        if (ServletFileUpload.isMultipartContent(request)) {
            //创建表单项 FileItem 的工厂类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类 ServletFileUpLoad
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);


            try {
                //把上传的数据解析为每一个表单项
                List<FileItem> list = servletFileUpload.parseRequest(request);
                //遍历每一个表单项，做相应处理
                for (FileItem fileItem : list){
                    //普通表单项
                    if (fileItem.isFormField()){
                        System.out.println("name => " + fileItem.getFieldName());
                        System.out.println("表单项的值：" + fileItem.getString("utf-8"));
                    } else {
                        //上传的是文件
                        System.out.println("name => " + fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());
                        fileItem.write(new File("D:\\XXZL\\" + fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
