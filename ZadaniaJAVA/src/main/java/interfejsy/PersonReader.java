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
public interface PersonReader {
    List<Person> readPersons(String filePath) throws IOException;
}
