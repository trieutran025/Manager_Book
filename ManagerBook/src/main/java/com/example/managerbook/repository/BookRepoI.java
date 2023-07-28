package com.example.managerbook.repository;

import com.example.managerbook.bean.Book;

import java.util.List;

public interface BookRepoI {
    List<Book> findAllBook();
    Book findByIdBook(int idBook);
}
