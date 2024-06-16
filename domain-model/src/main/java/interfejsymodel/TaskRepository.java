/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfejsymodel;

import com.mycompany.domain.model.Task;
import java.util.List;
/**
 *
 * @author dawid
 */
public interface TaskRepository {
    List<Task> getAllTasks();
    void saveAllTasks(List<Task> tasks);
}
