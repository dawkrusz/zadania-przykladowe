/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.model;

/**
 *
 * @author dawid
 */
public class Book extends Item {
    private String author;

    public Book(String name, String author, int minAge) {
        super(name, minAge);
        setAuthor(author);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty() || author.length() > 100) {
            throw new IllegalArgumentException("Autor musi mieć od 1 do 100 znaków.");
        }
        this.author = author;
    }
}
