package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookServiceTest {
    BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"1",new BigDecimal(2),"3",4,5,null));
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(24,"9",new BigDecimal(8),"7",4,5,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(24);
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(1);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> bookList = bookService.queryBooks();
        System.out.println(bookList);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

}