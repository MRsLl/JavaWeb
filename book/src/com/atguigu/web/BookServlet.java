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
import java.util.List;

@WebServlet(value = "/manager/bookServlet")
public class BookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.执行BookService 的查询全部图书方法
        List<Book> bookList = bookService.queryBooks();
        //2.把查询出来的图书列表添加进request域中
        request.setAttribute("list",bookList);
        //3.转发到book_manager页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.利用WebUtils 的静态方法把 request 域中参数注入 Book 对象
        Book book = WebUtils.copyParamToBean(new Book(), request.getParameterMap());
        //2.调用BookService 的添加图书方法
        bookService.addBook(book);
        // 调用list方法,查询并跳转到book_manager.jsp页面
//        list(request,response);
        //3.使用重定向跳转到图书列表管理页面
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用BookService 的删除图书方法
//        bookService.deleteBookById(new Integer(request.getParameter("id")));
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        bookService.deleteBookById(id);
        //2.使用重定向跳转到图书列表管理页面
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void getBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求的id
        Integer id = WebUtils.parseInt(request.getParameter("id"), 0);
        //2.根据id 获取指定图书对象
        Book book = bookService.queryBookById(id);
        //3.将获取的图书对象添加到 request 域中
        request.setAttribute("book",book);
        //4.转发到修改图书页面
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.利用WebUtils 的静态方法把 request 域中参数注入 Book 对象
        Book book = WebUtils.copyParamToBean(new Book(), request.getParameterMap());
        //2.调用 BookService 的 修改图书信息方法
        bookService.updateBook(book);
        //3.重定向到图书列表管理页面
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求的参数
        Integer pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.调用bookService 的page 方法
        Page<Book> page = bookService.page(pageNo, pageSize);
        //设置请求地址
        page.setUrl("manager/bookServlet?action=page");
        //3.保存到 request 域中
        request.setAttribute("page",page);
        //4.请求转发到 /pages/manager/book_manager.jsp 页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }
}
