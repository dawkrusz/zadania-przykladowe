/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadaniajava2;

/**
 *
 * @author dawid
 */
public class Book {

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    private String title;
    private String author;
    private int year;
    private String isbn;
    private int quantity;
    
    public Book(String title, String author, int year, String isbn, int quantity){
        if (title.length() > 100 || title.isEmpty()) throw new IllegalArgumentException("Niewlasciwy tytul");
        if (author.length() > 50 || author.isEmpty()) throw new IllegalArgumentException("Niewlasciwy autor");
        if (String.valueOf(year).length() != 4) throw new IllegalArgumentException("Niewlasciwy rok");
        if (isbn.length() != 13) throw new IllegalArgumentException("Niewlasciwy isbn");
    }
    
}
