/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadaniajava2;

import java.util.Scanner;
/**
 *
 * @author dawid
 */
public class LibraryManager {
    private Library library = new Library();
    private Scanner scanner = new Scanner(System.in);
    
    public void start(){
        while (true){
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    showAllBooks();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("niewlasciwy wybor");
                    
            }
        }
    }
    
    private void showMenu(){
        System.out.println("Wybierz: ");
        System.out.println("1. dodaj ksiazke");
        System.out.println("2. usun ksiazke");
        System.out.println("3. wyszukaj ksiazke");
        System.out.println("4. wypozycz ksiazke");
        System.out.println("5. oddaj ksiazke");
        System.out.println("6. pokaz wszystkie ksiazki");
        System.out.println("7. exit");
        System.out.println("Podaj swoj wybor: ");
    }
    
    private void addBook(){
        System.out.println("Podaj tytul: ");
        String title = scanner.nextLine();
        System.out.println("Podaj autora: ");
        String author = scanner.nextLine();
        System.out.println("Poidaj rok: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("podaj isbn: ");
        String isbn = scanner.nextLine();
        library.addBook(new Book(title, author, year, isbn, 1));
        System.out.println("ksiazka dodana okej");
    }
    
    public void removeBook(){
        System.out.println("Podaj isbn: ");
        String isbn = scanner.nextLine();
        library.removeBook(isbn);
        System.out.println("ksiazka usunieta okej");
    }
    
    private void searchBook(){
        System.out.println("wyszukaj przez: 1. tytul 2. autor 3. rok 4. isbn");
        System.out.println("podaj numer: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                System.out.println("Podaj tytul: ");
                String title = scanner.nextLine();
                library.searchByTitle(title).forEach(book -> System.out.println(book.getTitle()));
                break;
            case 2:
                System.out.println("podaj autora");
                String author = scanner.nextLine();
                library.searchByAuthor(author).forEach(book -> System.out.println(book.getAuthor()));
                break;
            case 3:
                System.out.println("podaj rok: ");
                int year = Integer.parseInt(scanner.nextLine());
                library.searchByYear(year).forEach(book -> System.out.println(book.getYear()));
                break;
            case 4:
                System.out.println("podaj isbn: ");
                String isbn = scanner.nextLine();
                Book book = library.searchByIsbn(isbn);
                if (book != null){
                    System.out.println(book.getTitle());
                }else{
                    System.out.println("Nie ma ksiazki o podanym isbn: " + isbn);
                }
                break;
            default:
                System.out.println("zly wybor");
        }
    }
    
    private void borrowBook(){
        System.out.println("Podaj isbn: ");
        String isbn = scanner.nextLine();
        if (library.borrowBook(isbn)){
            System.out.println("ksiazka wypozyczona poprawnie");
        }else{
            System.out.println("ksiazka niedostepna");
        }
    }
    
    private void returnBook(){
        System.out.println("Podja isbn: ");
        String isbn = scanner.nextLine();
        library.returnBook(isbn);
        System.out.println("ksiazka");
    }
    
    private void showAllBooks(){
        library.getAllBooks().forEach(book -> System.out.println(book.getTitle()));
    }
    
}
