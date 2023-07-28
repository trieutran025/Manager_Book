package com.example.managerbook.repository.impl;

import com.example.managerbook.bean.Book;
import com.example.managerbook.repository.BookRepoI;
import com.example.managerbook.util.Constants;
import com.example.managerbook.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepoImpl implements BookRepoI {
    @Override
    public List<Book> findAllBook() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.FIND_ALL_BOOK)) {
            ResultSet resultSet =statement.executeQuery();
            Book book;
            while (resultSet.next()) {
                int idBook = resultSet.getInt("id_book");
                String codeBook = resultSet.getString("code_book");
                String name_book = resultSet.getString("name_book");
                String tacGia = resultSet.getString("tac_gia");
                String moTa = resultSet.getString("mo_ta");
                int quantity = resultSet.getInt("quantity");
                book = new Book(idBook, codeBook,name_book, tacGia, moTa, quantity);
                books.add(book);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public Book findByIdBook(int idBook) {
        Book book=null;
        try(Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement  = connection.prepareStatement(Constants.FIND_BY_ID_BOOK)) {
            statement.setInt(1, idBook);
            ResultSet resultSet =statement.executeQuery();
            if(resultSet.next()){
                String codeBook = resultSet.getString("code_book");
                String nameBook = resultSet.getString("name_book");
                String tacGia = resultSet.getString("tac_gia");
                String moTa = resultSet.getString("mo_ta");
                int quantity = resultSet.getInt("quantity");
                book = new Book(idBook, codeBook,nameBook, tacGia, moTa, quantity);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }
}
