package com.example.managerbook.bean;

public class Book {
    private int idBook;
    private String codeBook;
    private String nameBook;
    private String tacGia;
    private String moTa;
    private int quantity;

    public Book(int idBook, String codeBook, String nameBook, String tacGia, String moTa, int quantity) {
        this.idBook = idBook;
        this.codeBook = codeBook;
        this.nameBook = nameBook;
        this.tacGia = tacGia;
        this.moTa = moTa;
        this.quantity = quantity;
    }

    public Book() {
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String codeBook) {
        this.codeBook = codeBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
