/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.zadaniajava;
import interfejsy.PersonReader;
import interfejsy.PersonWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dawid
 */
public class Main {

    public static void main(String[] args){
        String inputFilePath = "src/main/resources/people.csv";
        
        PersonReader personReader = new CsvPersonReader();
        List<Person> persons;
        try {
            persons = personReader.readPersons(inputFilePath);
        }catch (IOException e) {
            System.err.println("Blad podczas wczytywania: " + e.getMessage());
            return;
        }
        
        PersonAnalyzer analyzer = new PersonAnalyzer(persons);
        double averageAge = analyzer.calculateAverageAge();
        Person personWithLongestLastName = analyzer.findPersonWithLongestLastName();
        List<Person> sortedPersons = analyzer.sortPersonsByAgeDescending();
        
        System.out.println("Średni wiek: " + averageAge);
        System.out.println("Osoba z najdłuższym nazwiskiem: " + personWithLongestLastName);
        System.out.println("Osoby posortowane według wieku malejąco: ");
        for (Person person : sortedPersons){
            System.out.println(person);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe pliku do zapisania wyników: ");
        String outputFilePath = scanner.nextLine();
        
        PersonWriter personWriter = new TextPersonWriter();
        
        try{
            personWriter.writeAnalysis(outputFilePath, averageAge, personWithLongestLastName, sortedPersons);
            System.out.println("Wyniki analizy zapisane do pliku o nazwie: " + outputFilePath);
        } catch (IOException e){
            System.err.println("Blad podczas zapisywania wynikow: " + e.getMessage());
        }
        
        
    }
}
