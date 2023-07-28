package com.example.managerbook.bean;

public class CardBook {
    private int idCardBook;
    private Book book;
    private  Student student;
    private  String codeCardBook;
    private boolean status;
    private String dateMuon;
    private String dateTra;

    public CardBook(int idCardBook, Book book, Student student, String codeCardBook, boolean status, String dateMuon, String dateTra) {
        this.idCardBook = idCardBook;
        this.book = book;
        this.student = student;
        this.codeCardBook = codeCardBook;
        this.status = status;
        this.dateMuon = dateMuon;
        this.dateTra = dateTra;
    }

    public CardBook() {
    }

    public int getIdCardBook() {
        return idCardBook;
    }

    public void setIdCardBook(int idCardBook) {
        this.idCardBook = idCardBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCodeCardBook() {
        return codeCardBook;
    }

    public void setCodeCardBook(String codeCardBook) {
        this.codeCardBook = codeCardBook;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDateMuon() {
        return dateMuon;
    }

    public void setDateMuon(String dateMuon) {
        this.dateMuon = dateMuon;
    }

    public String getDateTra() {
        return dateTra;
    }

    public void setDateTra(String dateTra) {
        this.dateTra = dateTra;
    }
}
