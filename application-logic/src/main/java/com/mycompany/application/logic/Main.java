/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.application.logic;

import com.mycompany.domain.model.Task;
import interfejsymodel.TaskService;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author dawid
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskService taskService = new TaskServiceImpl(new CsvTaskRepository("tasks.csv"));
        
        List<Task> tasks = taskService.loadTasks();
        tasks.forEach(System.out::println);
        
        System.out.println("Czy chcesz posortowac zadania wg daty utworzenia, wybierz 1 , jeżeli chcesz posortować od największego priorytetu do najmniejszego, wybierz 2 ");
        int sortOption = scanner.nextInt();
        if (sortOption == 1){
            taskService.sortTasksByCreationDate(tasks);
        }else if(sortOption == 2){
            taskService.sortTasksByPriority(tasks);
        }
        tasks.forEach(System.out::println);
        
        System.out.println("Podaj ID wykonanych zadań, oddzielaj je przecinkiem (,): ");
        scanner.nextLine();
        String[] doneIds = scanner.nextLine().split(",");
        for (String idStr : doneIds){
            int id = Integer.parseInt(idStr.trim());
            tasks.stream()
                    .filter(task -> task.getId() == id)
                    .forEach(task -> task.getDone(true));
        }
        
        long totalTasks = tasks.size();
        long doneTasks = tasks.stream().filter(Task::getDone).count();
        long remainingTasks = totalTasks - doneTasks;
        
        
        System.out.println("Zadania do wykonania z podzialem na typ: ");
        tasks.stream()
                .filter(task -> !task.getDone())
                .collect(Collectors.groupingBy(Task::getType, Collectors.counting()))
                .forEach((type, count) -> System.out.println(type + ": "+ count));
        
        System.out.println("Zadania wykonanie: " + doneTasks);
    
        System.out.println("Maksymalny priorytet niewykonanego zadania: " +
                tasks.stream().filter(task -> !task.getDone()).mapToInt(Task::getPriority).max().orElse(0));
        System.out.println("Pozostale zadania do wykonania: " + remainingTasks);
        
        
        taskService.saveTasks(tasks);
        System.out.println("Program zakonczyl dzialanie");
        
                
    }
}
