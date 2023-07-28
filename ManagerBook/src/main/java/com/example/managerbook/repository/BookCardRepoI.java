package com.example.managerbook.repository;

import com.example.managerbook.bean.CardBook;

import java.util.List;

public interface BookCardRepoI {
    public List<CardBook> findAllBookCard();
    void add(CardBook cardBook);

    boolean deleteBookCard(int idCardBook);
}

