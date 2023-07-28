package com.example.managerbook.serrvice.Impl;

import com.example.managerbook.bean.Book;
import com.example.managerbook.repository.BookRepoI;
import com.example.managerbook.repository.impl.BookRepoImpl;
import com.example.managerbook.serrvice.BookServiceI;

import java.util.List;

public class BookServiceImpl implements BookServiceI {
    BookRepoI bookRepoI = new BookRepoImpl();
    @Override
    public List<Book> findAllBook() {
        return bookRepoI.findAllBook();
    }

    @Override
    public Book findByIdBook(int idBook) {
        return bookRepoI.findByIdBook(idBook);
    }
}
