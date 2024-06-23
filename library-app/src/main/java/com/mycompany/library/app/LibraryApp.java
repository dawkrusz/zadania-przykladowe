/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.library.app;

import com.mycompany.library.model.BoardGame;
import com.mycompany.library.model.Book;
import com.mycompany.library.model.Customer;
import com.mycompany.library.model.Item;
import com.mycompany.library.model.Rental;
import interfejsy.RentalService;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author dawid
 */
public class LibraryApp {
    private RentalService rentalService;
    private Scanner scanner;

    public LibraryApp() {
        this.rentalService = new RentalServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = getMenuChoice();
            try {
                switch (choice) {
                    case 1:
                        addNewRental();
                        break;
                    case 2:
                        displayRentals();
                        break;
                    case 3:
                        generateReport();
                        break;
                    case 4:
                        saveToFile();
                        break;
                    case 5:
                        System.out.println("Dziękujemy za skorzystanie z programu!");
                        return;
                    default:
                        System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
                }
            } catch (Exception e) {
                System.out.println("Wystąpił błąd: " + e.getMessage());
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n1. Dodaj nowe wypożyczenie");
        System.out.println("2. Wyświetl listę wypożyczeń");
        System.out.println("3. Wygeneruj raport");
        System.out.println("4. Zapisz do pliku");
        System.out.println("5. Zakończ program");
        System.out.print("Wybierz opcję: ");
    }

    private int getMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void addNewRental() {
        System.out.println("Wybierz typ pozycji (1 - Książka, 2 - Gra planszowa):");
        int itemType = Integer.parseInt(scanner.nextLine());

        Item item;
        if (itemType == 1) {
            System.out.print("Podaj nazwę książki: ");
            String name = scanner.nextLine();
            System.out.print("Podaj autora: ");
            String author = scanner.nextLine();
            System.out.print("Podaj minimalny wiek: ");
            int minAge = Integer.parseInt(scanner.nextLine());
            item = new Book(name, author, minAge);
        } else if (itemType == 2) {
            System.out.print("Podaj nazwę gry: ");
            String name = scanner.nextLine();
            System.out.print("Podaj minimalny wiek: ");
            int minAge = Integer.parseInt(scanner.nextLine());
            System.out.print("Podaj maksymalny wiek: ");
            int maxAge = Integer.parseInt(scanner.nextLine());
            item = new BoardGame(name, minAge, maxAge);
        } else {
            throw new IllegalArgumentException("Nieprawidłowy typ pozycji.");
        }

        System.out.print("Podaj imię klienta: ");
        String firstName = scanner.nextLine();
        System.out.print("Podaj nazwisko klienta: ");
        String lastName = scanner.nextLine();
        System.out.print("Podaj wiek klienta: ");
        int age = Integer.parseInt(scanner.nextLine());

        Customer customer = new Customer(firstName, lastName, age);

        if (customer.getAge() < item.getMinAge() || (item instanceof BoardGame && customer.getAge() > ((BoardGame) item).getMaxAge())) {
            System.out.println("Ostrzeżenie: Pozycja niedostosowana do wieku klienta!");
        }

        Rental rental = new Rental(item, customer);
        rentalService.addRental(rental);
        System.out.println("Dodano nowe wypożyczenie.");
    }

    private void displayRentals() {
        List<Rental> rentals = rentalService.getRentals();
        for (int i = 0; i < rentals.size(); i++) {
            Rental rental = rentals.get(i);
            String itemType = rental.getItem() instanceof Book ? "Książka" : "Gra planszowa";
            String author = rental.getItem() instanceof Book ? ((Book) rental.getItem()).getAuthor() : "N/A";
            System.out.printf("%d. %s, %s, %s, %s, %d\n",
                    i + 1,
                    rental.getItem().getName(),
                    author,
                    itemType,
                    rental.getCustomer().getLastName(),
                    rental.getCustomer().getAge());
        }
    }

    private void generateReport() {
        RentalReport report = rentalService.generateReport();
        System.out.println("Raport wypożyczeń:");
        System.out.println("Liczba wypożyczonych książek: " + report.getBookCount());
        System.out.println("Liczba wypożyczonych gier: " + report.getBoardGameCount());
        System.out.println("Liczba wypożyczeń przez dzieci: " + report.getChildrenCount());
        System.out.println("Liczba wypożyczeń przez młodzież: " + report.getTeenCount());
        System.out.println("Liczba wypożyczeń przez dorosłych: " + report.getAdultCount());
    }

    private void saveToFile() {
        System.out.print("Podaj nazwę pliku do zapisu: ");
        String fileName = scanner.nextLine();
        try {
            rentalService.saveToFile(fileName);
            System.out.println("Zapisano wypożyczenia do pliku: " + fileName);
        } catch (IOException e) {
            System.out.println("Błąd podczas zapisu do pliku: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new LibraryApp().run();
    }
}
