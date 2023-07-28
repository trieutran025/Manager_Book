package com.example.managerbook.serrvice;

import com.example.managerbook.bean.CardBook;

import java.util.List;

public interface BookCardServiceI {
     List<CardBook> findAllBookCard();
     boolean deleteBookCard(int idBookCard);
    void add(CardBook cardBook);
}
