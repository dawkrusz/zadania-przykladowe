/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.library.domain;

import interfejsy_domain.Rentable;

/**
 *
 * @author dawid
 */
public class Rental {

    private Rentable item;
    private String firstName;
    private String lastName;
    private int age;
    
    public Rental(Rentable item, String firstName, String lastName, int age) {
        this.item = item;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Rentable getItem() {
        return item;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
    
    @Override
    public String toString(){
        return String.format("%s, %s, %s, %s, %d", item.getName(), item.getDetails(), item.getType(), lastName, age);
    }

}
