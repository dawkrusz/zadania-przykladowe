/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadaniapliki;
import java.io.Serializable;
/**
 *
 * @author dawid
 */
public class User implements Serializable {
    private String firstName;
    private String lastName;
    private int age;
    private String email;

    public User(String firstName, String lastName, int age, String email) {
        if (!isValidAge(age)) {
            throw new IllegalArgumentException("Invalid age");
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    // Getters and Setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (!isValidAge(age)) {
            throw new IllegalArgumentException("Invalid age");
        }
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    // Validation methods

    private boolean isValidAge(int age) {
        return age > 0 && age < 150;
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}