package com.example.managerbook.util;

public class Constants {
    public static final String FIND_ALL_BOOK = "SELECT * FROM manager_book.book;";
    public static final String FIND_ALL_STUDENT = "SELECT * FROM manager_book.student;";
    public static final String FIND_ALL =
            "SELECT book.code_book,book.name_book,book.tac_gia,book.mo_ta,book.quantity,\n" +
                    "\t\tstudent.code_student,student.name_student,student.class_student,\n" +
                    "      book_card.id_card_book,  book_card .code_card_book,book_card.status,book_card.date_muon,book_card.date_tra\n" +
                    "        FROM book join book_card using(id_book) JOIN student using(id_student); ";
    public static final String FIND_ALL_CARD_BOOK = "SELECT * FROM manager_book.book_card;";
    public static String DELETE_CARD_BOOK = "DELETE FROM manager_book.book_card where id_card_book= ?;\n";
    public static final String ADD_CARD_BOOK = "insert into book_card values(?,?,?,?,?,?,?)";
    public static final String FIND_BY_ID_BOOK = "SELECT * FROM BOOK WHERE id_book = ?";
    public static final String FIND_BY_ID_STUDENT = "SELECT * FROM Student WHERE id_student = ?";
}
