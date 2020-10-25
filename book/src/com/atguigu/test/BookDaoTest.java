package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;


public class BookDaoTest {
    BookDao bookDao = new BookDaoImpl();

    @Test
    public void saveBook() {
        bookDao.saveBook(new Book(null,"1",new BigDecimal(2),"3",4,5,null));
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(23,"9",new BigDecimal(8),"7",4,5,null));
    }

    @Test
    public void deleteBook() {
        bookDao.deleteBook(23);
    }

    @Test
    public void queryBook() {
        Book book = bookDao.queryBook(1);
        System.out.println(book);
    }

    @Test
    public void queryBookList() {
        List<Book> bookList = bookDao.queryBookList();
        System.out.println(bookList);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageCountByprice() {
        Integer integer = bookDao.queryForPageCountByPrice(0, 80);
        System.out.println(integer);
    }

    @Test
    public void queryForPageItemsByprice() {
        List<Book> bookList = bookDao.queryForPageItemsByPrice(0, 4,0,80);
        System.out.println(bookList);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
}