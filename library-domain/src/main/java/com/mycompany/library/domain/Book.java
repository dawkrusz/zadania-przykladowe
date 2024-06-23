/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.domain;

import interfejsy_domain.Rentable;

/**
 *
 * @author dawid
 */
public class Book implements Rentable {
    private String title;
    private String author;
    private int minAge;
    
    public Book(String title, String author, int minAge){
        if (title.length() > 120 || author.length() > 100){
            throw new IllegalArgumentException("Dlugosc tytulu albo autora wieksza niz dozwolone");
        }
        this.title = title;
        this.author = author;
        this.minAge = minAge;
    }
    
    @Override
    public String getName(){
        return title;
    }
    
    @Override
    public int getMinAge(){
        return minAge;
    }
    
    @Override
    public String getDetails(){
        return author;
    }
    
    @Override
    public String getType(){
        return "Ksiazka";
    }

}
