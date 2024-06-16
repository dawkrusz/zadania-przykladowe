/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadaniajava;
import interfejsy.PersonReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author dawid
 */
public class CsvPersonReader implements PersonReader {
    @Override
    public List<Person> readPersons(String filePath) throws IOException {
        List<Person> persons = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                 if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                if (values.length == 4){
                    String firstName = values[0];
                    String lastName = values [1];
                    int age = Integer.parseInt(values[2]);
                    String email = values[3];
                    persons.add(new Person(firstName, lastName, age, email));
                }
            }
        }
        return persons;
    }
}
