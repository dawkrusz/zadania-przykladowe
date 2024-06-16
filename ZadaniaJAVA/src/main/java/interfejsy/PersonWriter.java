/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfejsy;

import com.mycompany.zadaniajava.Person;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author dawid
 */
public interface PersonWriter {
    void writeAnalysis(String filePath, double averageAge, Person personWithLongestLastName, List<Person> sortedPersons) throws IOException;
}
