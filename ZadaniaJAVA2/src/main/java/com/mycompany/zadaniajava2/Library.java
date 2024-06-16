/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadaniajava2;

import java.util.*;
/**
 *
 * @author dawid
 */
public class Library {
    private Map<String, Book> books = new HashMap<>();
    
    public void addBook(Book book){
        books.putIfAbsent(book.getIsbn(), book);
        books.computeIfPresent(book.getIsbn(), (k,v)->{
            v.setQuantity(v.getQuantity()+1);
            return v;
        });
    }
    
    public void removeBook(String isbn){
        Book book = books.get(isbn);
        if (book != null){
            if (book.getQuantity()>1){
                book.setQuantity(book.getQuantity()-1);
            }else{
                books.remove(isbn);
            }
        } else{
            System.out.println("Nie ma ksiazki z podanym isbn: " + isbn);
        }
    }
    
    public Book searchByIsbn(String isbn){
        return books.get(isbn);
    }
    
    public List<Book> searchByTitle(String title){
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()){
            if (book.getTitle().equalsIgnoreCase(title)){
                result.add(book);
            }
        }
        return result;
    }
    
    public List<Book> searchByAuthor(String author){
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()){
            if (book.getAuthor().equalsIgnoreCase(author)){
                result.add(book);
            }
        }
        return result;
    }
    
    public List<Book> searchByYear(int year){
        List<Book> result = new ArrayList<>();
        for (Book book : books.values()){
            if (book.getYear() == year){
                result.add(book);
            }
        }
        return result;
    }
    
    public List<Book> getAllBooks(){
        return new ArrayList<>(books.values());
    }
    
    public boolean borrowBook(String isbn){
        Book book = books.get(isbn);
        if(book != null && book.getQuantity()>0){
            book.setQuantity(book.getQuantity()-1);
            return true;
        }
        return false;
    }
    
    public void returnBook(String isbn){
        Book book = books.get(isbn);
        if(book != null){
            book.setQuantity(book.getQuantity()+1);
        }
    }
    
}
