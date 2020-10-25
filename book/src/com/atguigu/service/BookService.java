package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

public interface BookService {
    /**
     * 添加图书
     * @param book
     */
    void addBook (Book book);

    /**
     * 更新图书
     * @param book
     */
    void updateBook (Book book);

    /**
     * 通过id主键删除图书
     * @param id
     */
    void deleteBookById (Integer id);

    /**
     * 通过id主键查找图书
     * @param id
     * @return
     */
    Book queryBookById (Integer id);

    /**
     * 查询所有图书
     * @return
     */
    List<Book> queryBooks ();

    /**
     * 根据页面编号和每页显示数量获取要显示的图书记录
     * @return
     */
    Page<Book> page(Integer pageNo,Integer pageSize);

    /**
     * 根据页面编号和每页显示数量以及价格区间获取要显示的图书记录
     * @param pageNo
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max);
}
