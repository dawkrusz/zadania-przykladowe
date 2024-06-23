/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfejsy;

import com.mycompany.library.app.RentalReport;
import com.mycompany.library.model.Rental;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author dawid
 */
public interface RentalService {
    void addRental(Rental rental);
    List<Rental> getRentals();
    RentalReport generateReport();
    void saveToFile(String fileName) throws IOException;
}
