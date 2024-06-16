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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvUserSerializer implements UserSerializerInterface {

    @Override
    public void serialize(List<User> users, String filename) throws Exception {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (User user : users) {
                writer.write(user.getFirstName() + ";" + user.getLastName() + ";" +
                        user.getAge() + ";" + user.getEmail());
                writer.newLine();
            }
        }
    }

    @Override
    public List<User> deserialize(String filename) throws Exception {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    users.add(new User(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]));
                }
            }
        }
        return users;
    }
}