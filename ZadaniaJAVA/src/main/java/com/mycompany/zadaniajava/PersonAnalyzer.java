/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadaniajava;

import java.util.Comparator;
import java.util.List;
/**
 *
 * @author dawid
 */
public class PersonAnalyzer {
    
    private final List<Person> persons;
    
     public PersonAnalyzer(List<Person> persons) {
        this.persons = persons;
    }
     
    public double calculateAverageAge(){
        return persons.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
    }
    
    public Person findPersonWithLongestLastName(){
        return persons.stream()
                .max(Comparator.comparingInt(person -> person.getLastName().length()))
                .orElse(null);
    }
    
    public List<Person> sortPersonsByAgeDescending(){
        persons.sort(Comparator.comparingInt(Person::getAge).reversed());
        return persons;
    }
}
