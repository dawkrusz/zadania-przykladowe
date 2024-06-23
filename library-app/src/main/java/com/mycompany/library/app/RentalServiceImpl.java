/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.app;

import com.mycompany.library.model.BoardGame;
import com.mycompany.library.model.Book;
import com.mycompany.library.model.Rental;
import interfejsy.RentalService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dawid
 */
public class RentalServiceImpl implements RentalService {
    private List<Rental> rentals = new ArrayList<>();

    @Override
    public void addRental(Rental rental) {
        if (rental == null) {
            throw new IllegalArgumentException("Wypożyczenie nie może być null.");
        }
        rentals.add(rental);
    }

    @Override
    public List<Rental> getRentals() {
        return new ArrayList<>(rentals);
    }

    @Override
    public RentalReport generateReport() {
        RentalReport report = new RentalReport();
        for (Rental rental : rentals) {
            if (rental.getItem() instanceof Book) {
                report.incrementBookCount();
            } else if (rental.getItem() instanceof BoardGame) {
                report.incrementBoardGameCount();
            }

            int age = rental.getCustomer().getAge();
            if (age <= 10) {
                report.incrementChildrenCount();
            } else if (age <= 17) {
                report.incrementTeenCount();
            } else {
                report.incrementAdultCount();
            }
        }
        return report;
    }

    @Override
    public void saveToFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Rental rental : rentals) {
                writer.write(String.format("%s,%s,%s,%d\n",
                        rental.getItem().getName(),
                        rental.getItem() instanceof Book ? ((Book) rental.getItem()).getAuthor() : "N/A",
                        rental.getCustomer().getLastName(),
                        rental.getCustomer().getAge()));
            }
        }
    }
}
