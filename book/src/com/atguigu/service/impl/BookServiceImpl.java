package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.saveBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBook(id);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBook(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBookList();
    }

    @Override
    public Page<Book> page(Integer pageNo, Integer pageSize) {
        Page<Book> page = new Page<>();
        //设置每页要显示的数量
        page.setPageSize(pageSize);
        //获取总记录数
        Integer pageCount = bookDao.queryForPageCount();
        //设置总记录数
        page.setPageCount(pageCount);
        //求总页码
        Integer pageTotal = pageCount / pageSize;
        if (pageCount % pageSize > 0){
            pageTotal++;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //设置当前页码
        page.setPageNo(pageNo);
        //求分页数据的开始索引
        Integer begin = (page.getPageNo() - 1) * page.getPageSize();
        //求当页数据
        List<Book> items = bookDao.queryForPageItems(begin, page.getPageSize());
        //设置当前页数据
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max) {
        Page<Book> page = new Page<>();
        //设置每页要显示的数量
        page.setPageSize(pageSize);
        //获取总记录数
        Integer pageCount = bookDao.queryForPageCountByPrice(min, max);
        //设置总记录数
        page.setPageCount(pageCount);
        //求总页码
        Integer pageTotal = pageCount / pageSize;
        if (pageCount % pageSize > 0){
            pageTotal++;
        }
        //设置总页码
        page.setPageTotal(pageTotal);
        //设置当前页码
        page.setPageNo(pageNo);
        //求分页数据的开始索引
        Integer begin = (page.getPageNo() - 1) * page.getPageSize();
        //求当页数据
        List<Book> items = bookDao.queryForPageItemsByPrice(begin, page.getPageSize(),min,max);
        //设置当前页数据
        page.setItems(items);
        return page;
    }
}
