/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.application.logic;

import com.mycompany.domain.model.Task;
import interfejsymodel.TaskRepository;
import interfejsymodel.TaskService;
import java.util.List;

/**
 *
 * @author dawid
 */
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    
    @Override
    public List<Task> loadTasks(){
        List<Task> tasks = taskRepository.getAllTasks();
        System.out.println("Zadania zostaly wczytane ");
        return tasks;
    }
    
    @Override
    public void saveTasks(List<Task> tasks){
        taskRepository.saveAllTasks(tasks);
        System.out.println("Zadania zostaly zapisane");
    }
    
    @Override
    public List<Task> sortTasksByCreationDate(List<Task> tasks){
        tasks.sort((t1, t2) -> t1.getCreationDate().compareTo(t2.getCreationDate()));
        return tasks;
    }
    
    @Override
    public List<Task> sortTasksByPriority(List<Task> tasks){
        tasks.sort((t1,t2) -> Integer.compare(t2.getPriority(), t1.getPriority()));
        return tasks;
    }
}
