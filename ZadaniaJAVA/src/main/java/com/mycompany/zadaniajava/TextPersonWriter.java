/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadaniajava;

import interfejsy.PersonWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author dawid
 */
public class TextPersonWriter implements PersonWriter{
    @Override
    public void writeAnalysis(String filePath, double averageAge, Person personWithLongestLastName, List<Person> sortedPersons) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write("Średni wiek: " + averageAge);
            writer.newLine();
            writer.write("Osoba z najdłuższym nazwiskiem: " + personWithLongestLastName);
            writer.newLine();
            writer.write("Osoby posortowane według wieku malejąco: ");
            writer.newLine();
            for (Person person : sortedPersons){
                writer.write(person.toString());
                writer.newLine();
            }
        }
    }
}
