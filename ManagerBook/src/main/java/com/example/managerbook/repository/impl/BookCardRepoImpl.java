package com.example.managerbook.repository.impl;

import com.example.managerbook.bean.Book;
import com.example.managerbook.bean.CardBook;
import com.example.managerbook.bean.Student;
import com.example.managerbook.repository.BookCardRepoI;
import com.example.managerbook.repository.BookRepoI;
import com.example.managerbook.repository.StudentRepoI;
import com.example.managerbook.util.Constants;
import com.example.managerbook.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCardRepoImpl implements BookCardRepoI {
    BookRepoI bookRepoI = new BookRepoImpl();
    StudentRepoI studentRepo = new StudentRepoImpl();
    @Override
    public List<CardBook> findAllBookCard() {
        List<CardBook> cardBooks = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.FIND_ALL)) {
            ResultSet resultSet =statement.executeQuery();
            CardBook cardBook;
            while (resultSet.next()) {
                Book book = new Book();
                book.setCodeBook(resultSet.getString("code_book"));
                book.setNameBook(resultSet.getString("name_book"));
                book.setTacGia(resultSet.getString("tac_gia"));
                book.setMoTa(resultSet.getString("mo_ta"));
                book.setQuantity(resultSet.getInt("quantity"));
                Student student = new Student();
                student.setCodeStudent(resultSet.getString("code_student"));
                student.setNameStudent(resultSet.getString("name_student"));
                student.setClassStudent(resultSet.getString("class_student"));
                int idCardBook = resultSet.getInt("id_card_book");
                String codeCardBook = resultSet.getString("code_card_book");
                boolean status = resultSet.getBoolean("status");
                String dateMuon = resultSet.getString("date_muon");
                String dateTra = resultSet.getString("date_tra");
                cardBook = new CardBook(idCardBook, book, student,codeCardBook, status, dateMuon,dateTra);
                cardBooks.add(cardBook);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cardBooks;
    }

    @Override
    public void add(CardBook cardBook) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(Constants.ADD_CARD_BOOK)) {
            statement.setInt(1, cardBook.getIdCardBook());
            statement.setInt(2, cardBook.getBook().getIdBook());
            statement.setInt(3, cardBook.getStudent().getIdStudent());
            statement.setString(4, cardBook.getCodeCardBook());
            statement.setBoolean(5, cardBook.getStatus());
            statement.setString(6, cardBook.getDateMuon());
            statement.setString(7, cardBook.getDateTra());
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteBookCard(int idCardBook) {
        try (Connection connection =DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(Constants.DELETE_CARD_BOOK);){
            statement.setInt(1,idCardBook);
            statement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
