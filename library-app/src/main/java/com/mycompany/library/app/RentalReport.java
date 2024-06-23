/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.app;

/**
 *
 * @author dawid
 */
public class RentalReport {
    private int bookCount;
    private int boardGameCount;
    private int childrenCount;
    private int teenCount;
    private int adultCount;

    // Gettery
    public int getBookCount() { return bookCount; }
    public int getBoardGameCount() { return boardGameCount; }
    public int getChildrenCount() { return childrenCount; }
    public int getTeenCount() { return teenCount; }
    public int getAdultCount() { return adultCount; }

    // Inkrementatory
    public void incrementBookCount() { bookCount++; }
    public void incrementBoardGameCount() { boardGameCount++; }
    public void incrementChildrenCount() { childrenCount++; }
    public void incrementTeenCount() { teenCount++; }
    public void incrementAdultCount() { adultCount++; }
}
