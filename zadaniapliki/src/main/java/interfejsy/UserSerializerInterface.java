/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfejsy;
import com.mycompany.zadaniapliki.User;
import java.util.List;
/**
 *
 * @author dawid
 */
public interface UserSerializerInterface {
    void serialize(List<User> users, String filename) throws Exception;
    List<User> deserialize(String filename) throws Exception;
}
