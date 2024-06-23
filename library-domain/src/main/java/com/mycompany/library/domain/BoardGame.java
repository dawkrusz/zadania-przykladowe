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
public class BoardGame implements Rentable {
    private String name;
    private int minAge;
    private int maxAge;
    
    public BoardGame(String name, int minAge, int maxAge){
        if(name.length() > 120){
            throw new IllegalArgumentException("Nazwa gry za dluga");
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMinAge() {
        return minAge;
    }
    
    public int getMaxAge(){
        return maxAge;
    }

    @Override
    public String getDetails() {
        return "Miniwalny wiek: " + minAge + ", maksymalny wiek: " + maxAge;
    }

    @Override
    public String getType() {
        return "Gra planszowa";
    }
}
