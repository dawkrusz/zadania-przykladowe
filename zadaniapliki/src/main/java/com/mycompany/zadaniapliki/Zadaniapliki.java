/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.zadaniapliki;

/**
 *
 * @author dawid
 */
import interfejsy.UserSerializerInterface;
import java.util.Scanner;

public class Zadaniapliki {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserSerializerInterface serializer = null;

        System.out.println("Choose a file format for storage: 1. CSV 2. Binary 3. JSON 4. XML");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                serializer = new CsvUserSerializer();
                break;
            case 2:
                serializer = new BinaryUserSerializer();
                break;
            case 3:
                serializer = new JsonUserSerializer();
                break;
            case 4:
                serializer = new XmlUserSerializer();
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                System.exit(1);
        }

        UserManager userManager = new UserManager(serializer);

        System.out.println("Enter filename to load users from (leave blank to skip): ");
        String loadFilename = scanner.nextLine();
        if (!loadFilename.isEmpty()) {
            userManager.loadUsers(loadFilename);
        }

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add user");
            System.out.println("2. Remove user");
            System.out.println("3. Display users");
            System.out.println("4. Save users");
            System.out.println("5. Load users");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    userManager.addUser(firstName, lastName, age, email);
                    break;
                case 2:
                    System.out.print("Enter user index to remove: ");
                    int index = scanner.nextInt();
                    userManager.removeUser(index - 1);
                    break;
                case 3:
                    userManager.displayUsers();
                    break;
                case 4:
                    System.out.print("Enter filename to save users: ");
                    String saveFilename = scanner.nextLine();
                    userManager.saveUsers(saveFilename);
                    break;
                case 5:
                    System.out.print("Enter filename to load users: ");
                    String loadFile = scanner.nextLine();
                    userManager.loadUsers(loadFile);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
