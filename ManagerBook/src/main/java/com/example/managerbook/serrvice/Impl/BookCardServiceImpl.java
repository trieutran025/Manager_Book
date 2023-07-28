package com.example.managerbook.serrvice.Impl;

import com.example.managerbook.bean.CardBook;
import com.example.managerbook.repository.BookCardRepoI;
import com.example.managerbook.repository.impl.BookCardRepoImpl;
import com.example.managerbook.serrvice.BookCardServiceI;

import java.util.List;

public class BookCardServiceImpl implements BookCardServiceI {
    BookCardRepoI bookCardRepoI = new BookCardRepoImpl();

    @Override
    public List<CardBook> findAllBookCard() {
        return bookCardRepoI.findAllBookCard();
    }

    @Override
    public boolean deleteBookCard(int idBookCard) {
       return bookCardRepoI.deleteBookCard(idBookCard);
    }

    @Override
    public void add(CardBook cardBook) {
        bookCardRepoI.add(cardBook);
    }
}
