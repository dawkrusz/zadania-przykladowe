/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadaniapliki;

/**
 *
 * @author dawid
 */
import interfejsy.UserSerializerInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private List<User> users;
    private UserSerializerInterface serializer;

    public UserManager(UserSerializerInterface serializer) {
        this.users = new ArrayList<>();
        this.serializer = serializer;
    }

    public void addUser(String firstName, String lastName, int age, String email) {
        try {
            users.add(new User(firstName, lastName, age, email));
            System.out.println("User added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeUser(int index) {
        if (index >= 0 && index < users.size()) {
            users.remove(index);
            System.out.println("User removed successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users in the list.");
        } else {
            for (int i = 0; i < users.size(); i++) {
                System.out.println((i + 1) + ". " + users.get(i));
            }
        }
    }

    public void saveUsers(String filename) {
        try {
            serializer.serialize(users, filename);
            System.out.println("Users saved successfully.");
        } catch (Exception e) {
            System.out.println("Failed to save users: " + e.getMessage());
        }
    }

    public void loadUsers(String filename) {
        try {
            users = serializer.deserialize(filename);
            System.out.println("Users loaded successfully.");
        } catch (Exception e) {
            System.out.println("Failed to load users: " + e.getMessage());
        }
    }
}