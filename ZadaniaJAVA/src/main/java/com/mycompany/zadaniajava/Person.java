/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadaniajava;

/**
 *
 * @author dawid
 */
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    
    public Person(String firstName, String lastName, int age, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }
    
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getAge(){
        return age;
    }
    public String getEmail(){
        return email;
    }
    
    @Override
    public String toString(){
        return firstName + " " + lastName + " " + age + "lat, email: " + email;
    }
}
