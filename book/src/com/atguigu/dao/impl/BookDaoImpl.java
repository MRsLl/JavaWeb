package com.atguigu.dao.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int saveBook(Book book) {
        String sql = "insert into t_book(`name`,`price`,`author`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImg_path());
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name = ?,price = ?,author = ?,sales = ?,stock = ?,img_path = ? where id = ?";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImg_path(), book.getId());
    }

    @Override
    public int deleteBook(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public Book queryBook(Integer id) {
        String sql = "select `name`,`author`,`price`,`sales`,`stock`,`img_path`,`id` from t_book where id = ?";
        return queryOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBookList() {
        String sql = "select `name`,`author`,`price`,`sales`,`stock`,`img_path`,`id` from t_book";
        return queryList(Book.class, sql);
    }

    @Override
    public Integer queryForPageCount() {
        String sql = "select count(*) from t_book";
        Object count = queryForSingleValue(sql);
        return new Integer(count.toString());
    }

    @Override
    public List<Book> queryForPageItems(Integer begin, Integer pageSize) {
        String sql = "select `name`,`author`,`price`,`sales`,`stock`,`img_path`,`id` from t_book limit ?,?";
        return queryList(Book.class, sql, begin, pageSize);
    }

    @Override
    public Integer queryForPageCountByPrice(Integer min, Integer max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Object count = queryForSingleValue(sql, min, max);
        return new Integer(count.toString());
    }

    @Override
    public List<Book> queryForPageItemsByPrice(Integer begin, Integer pageSize, Integer min, Integer max) {
        String sql = "select `name`,`author`,`price`,`sales`,`stock`,`img_path`,`id` from t_book where price between ? and ? order by price limit ?,? ";
        return queryList(Book.class, sql, min, max, begin, pageSize);
    }
}
