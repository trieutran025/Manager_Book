package com.example.managerbook.serrvice;

import com.example.managerbook.bean.Book;

import java.util.List;

public interface BookServiceI {
    List<Book> findAllBook();
    Book findByIdBook(int idBook);
}
