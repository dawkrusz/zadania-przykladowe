/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.model;

/**
 *
 * @author dawid
 */
public abstract class Item {
    protected String name;
    protected int minAge;

    public Item(String name, int minAge) {
        setName(name);
        setMinAge(minAge);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty() || name.length() > 120) {
            throw new IllegalArgumentException("Nazwa musi mieć od 1 do 120 znaków.");
        }
        this.name = name;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        if (minAge < 0) {
            throw new IllegalArgumentException("Minimalny wiek nie może być ujemny.");
        }
        this.minAge = minAge;
    }
}