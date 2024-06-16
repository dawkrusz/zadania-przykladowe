package com.mycompany.application.logic;

import com.mycompany.domain.model.Task;
import com.mycompany.domain.model.TaskType;
import interfejsymodel.TaskRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CsvTaskRepository implements TaskRepository {
    private final String filePath;

    public CsvTaskRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(", ");
                if (fields.length < 5) {
                    System.out.println("Niekompletna linia: " + line);
                    continue; // pomiń niekompletne linie
                }
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                TaskType type = TaskType.valueOf(fields[2].toUpperCase());
                int priority = Integer.parseInt(fields[3]);
                LocalDate creationDate = LocalDate.parse(fields[4]);
                boolean done = fields.length > 5 && fields[5].equalsIgnoreCase("wykonane");
                tasks.add(new Task(id, name, type, priority, creationDate, done));
            }
        } catch (IOException e) {
            System.out.println("Nie znaleziono zadnego zadania w pliku");
        }
        return tasks;
    }

    @Override
    public void saveAllTasks(List<Task> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                String line = String.format("%d, %s, %s, %d, %s, %s",
                        task.getId(),
                        task.getName(),
                        task.getType().name().toLowerCase(),
                        task.getPriority(),
                        task.getCreationDate(),
                        task.getDone() ? "wykonane" : "niewykonane");
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Nie można zapisać pliku");
        }
    }
}