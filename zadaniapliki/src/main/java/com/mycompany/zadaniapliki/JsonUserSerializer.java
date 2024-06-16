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
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class JsonUserSerializer implements UserSerializerInterface {

    @Override
    public void serialize(List<User> users, String filename) throws Exception {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("[\n");
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                writer.write("  {\n");
                writer.write("    \"firstName\": \"" + user.getFirstName() + "\",\n");
                writer.write("    \"lastName\": \"" + user.getLastName() + "\",\n");
                writer.write("    \"age\": " + user.getAge() + ",\n");
                writer.write("    \"email\": \"" + user.getEmail() + "\"\n");
                writer.write("  }");
                if (i < users.size() - 1) {
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]");
        }
    }

    @Override
    public List<User> deserialize(String filename) throws Exception {
        List<User> users = new ArrayList<>();
        try (FileReader reader = new FileReader(filename)) {
            StringBuilder json = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }

            String jsonString = json.toString();
            String[] objects = jsonString.substring(1, jsonString.length() - 1).split("\\},\\{");

            for (String obj : objects) {
                obj = obj.replace("{", "").replace("}", "");
                String[] fields = obj.split(",");
                String firstName = fields[0].split(":")[1].replace("\"", "").trim();
                String lastName = fields[1].split(":")[1].replace("\"", "").trim();
                int age = Integer.parseInt(fields[2].split(":")[1].trim());
                String email = fields[3].split(":")[1].replace("\"", "").trim();
                users.add(new User(firstName, lastName, age, email));
            }
        }
        return users;
    }
}