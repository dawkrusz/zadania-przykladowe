/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.model;

/**
 *
 * @author dawid
 */
public class BoardGame extends Item {
    private int maxAge;

    public BoardGame(String name, int minAge, int maxAge) {
        super(name, minAge);
        setMaxAge(maxAge);
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        if (maxAge < minAge) {
            throw new IllegalArgumentException("Maksymalny wiek nie może być mniejszy niż minimalny.");
        }
        this.maxAge = maxAge;
    }
}
