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
public interface TaskService {
    List<Task> loadTasks();
    void saveTasks(List<Task> tasks);
    List<Task> sortTasksByCreationDate(List<Task> tasks);
    List<Task> sortTasksByPriority(List<Task> tasks);
}
