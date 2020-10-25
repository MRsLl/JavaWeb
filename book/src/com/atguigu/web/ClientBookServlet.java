package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/client/bookServlet")
public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求的参数
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);

        //2.调用bookService 的page 方法
        Page<Book> page = bookService.page(pageNo, pageSize);
        //设置请求地址
        page.setUrl("client/bookServlet?action=page");
        //3.保存到 request 域中
        request.setAttribute("page",page);
        //4.请求转发到 /pages/client/index.jsp 页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }
    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求的参数
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Integer max = WebUtils.parseInt(request.getParameter("max"),Integer.MAX_VALUE);
        Integer min = WebUtils.parseInt(request.getParameter("min"),0);

        //2.调用bookService 的page 方法
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize,min,max);
        //设置请求地址
        StringBuilder url = new StringBuilder("client/bookServlet?action=pageByPrice");

        //判断最大最小值是否为空，不为空则追加到请求地址末尾
        String minStr = request.getParameter("min");
        if (minStr != null){
            url.append("&min=" + minStr);
        }

        String maxStr = request.getParameter("max");
        if (maxStr != null){
            url.append("&max=" + maxStr);
        }
        page.setUrl(url.toString());
        //3.保存到 request 域中
        request.setAttribute("page",page);
        //4.请求转发到 /pages/client/index.jsp 页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }

}
