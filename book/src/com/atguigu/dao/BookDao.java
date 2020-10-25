package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookDao {
    /**
     * 添加图书
     * @param book
     * @return
     */
    int saveBook(Book book);

    /**
     * 修改图书信息
     * @param book
     * @return
     */
    int updateBook(Book book);

    /**
     * 通过编号删除图书
     * @param id
     */
    int deleteBook(Integer id);

    /**
     * 通过图书编号查询一本图书
     * @param id
     * @return
     */
    Book queryBook(Integer id);

    /**
     * 查询图书列表
     * @return
     */
    List<Book> queryBookList();

    /**
     *查询总记录数
     * @return
     */
    Integer queryForPageCount();

    /**
     *查询指定页数的所有图书记录
     * @param begin 该页的第一条记录的id值
     * @param pageSize 每页显示的记录条数
     * @return
     */
    List<Book> queryForPageItems(Integer begin,Integer pageSize);

    /**
     * 根据价格区间查询所有图书记录总数
     * @param min
     * @param max
     * @return
     */
    Integer queryForPageCountByPrice(Integer min,Integer max);

    /**
     * 根据价格区间和页数查询图书记录
     * @param begin
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    List<Book> queryForPageItemsByPrice(Integer begin, Integer pageSize,Integer min,Integer max);
}
