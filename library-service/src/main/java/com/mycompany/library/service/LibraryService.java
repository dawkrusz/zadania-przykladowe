/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.library.service;

import com.mycompany.library.domain.BoardGame;
import com.mycompany.library.domain.Book;
import com.mycompany.library.domain.Rental;
import interfejsy_domain.Rentable;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dawid
 */
public class LibraryService {
    private List<Rental> rentals = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LibraryService service = new LibraryService();
        service.run();
    }

    public void run() {
        while (true) {
            showMenu();
            int choice = getIntInput("Wybierz opcje: ");
            switch (choice) {
                case 1:
                    addRental();
                    break;
                case 2:
                    listRentals();
                    break;
                case 3:
                    generateReport();
                    break;
                case 4:
                    saveToFile();
                    break;
                case 5:
                    System.out.println("Wychodze z programu...");
                    return;
                default:
                    System.out.println("Zly wybor, napisz jeszcze raz.");
            }
        }
    }

    private void showMenu() {
        System.out.println("1. Dodaj wypozyczenie");
        System.out.println("2. Pokaz wypozyczenia");
        System.out.println("3. Generate report");
        System.out.println("4. Save to file");
        System.out.println("5. Exit");
    }

    private void addRental() {
        int type = getIntInput("Choose type (1 for Book, 2 for Board Game): ");

        String firstName = getStringInput("Enter client's first name: ");
        String lastName = getStringInput("Enter client's last name: ");
        int age = getIntInput("Enter client's age: ");

        Rentable item;
        if (type == 1) {
            String title = getStringInput("Enter book title: ");
            String author = getStringInput("Enter book author: ");
            int minAge = getIntInput("Enter book minimum age: ");
            item = new Book(title, author, minAge);
        } else if (type == 2) {
            String name = getStringInput("Enter game name: ");
            int minAge = getIntInput("Enter game minimum age: ");
            int maxAge = getIntInput("Enter game maximum age: ");
            item = new BoardGame(name, minAge, maxAge);
        } else {
            System.out.println("Invalid type.");
            return;
        }

        if (age < item.getMinAge() || (item instanceof BoardGame && age > ((BoardGame) item).getMaxAge())) {
            System.out.println("Warning: Client does not meet the age requirements for this item.");
        } else {
            rentals.add(new Rental(item, firstName, lastName, age));
            System.out.println("Pomyslnie dodano wypozyczenie.");
        }
    }

    private void listRentals() {
        for (int i = 0; i < rentals.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, rentals.get(i));
        }
    }

    private void generateReport() {
        long bookCount = rentals.stream().filter(r -> r.getItem().getType().equals("Ksiazka")).count();
        long gameCount = rentals.stream().filter(r -> r.getItem().getType().equals("Gra planszowa")).count();
        long childrenCount = rentals.stream().filter(r -> r.getAge() <= 10).count();
        long teensCount = rentals.stream().filter(r -> r.getAge() >= 11 && r.getAge() <= 17).count();
        long adultsCount = rentals.stream().filter(r -> r.getAge() >= 18).count();

        System.out.printf("Books rented: %d%n", bookCount);
        System.out.printf("Board games rented: %d%n", gameCount);
        System.out.printf("Children rentals: %d%n", childrenCount);
        System.out.printf("Teen rentals: %d%n", teensCount);
        System.out.printf("Adult rentals: %d%n", adultsCount);
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rentals.txt", true))) {
            for (Rental rental : rentals) {
                writer.write(rental.toString());
                writer.newLine();
            }
            System.out.println("Rentals saved to file.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    private String getStringInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input != null && !input.trim().isEmpty()) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter a valid string.");
            }
        }
    }
}