/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.domain.model;
import java.time.LocalDate;
/**
 *
 * @author dawid
 */
public class Task {

    public Task(int id, String name, TaskType type, int priority, LocalDate creationDate, boolean done) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.priority = priority;
        this.creationDate = creationDate;
        this.done = done;
    }

    public Task(int id, String name, TaskType type, int priority, LocalDate creationDate) {
        this(id, name, type, priority, creationDate, false);
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TaskType getType() {
        return type;
    }

    public int getPriority() {
        return priority;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public boolean getDone() {
        return done;
    }
    
     public void getDone(boolean done) {
        this.done = done;
    }

    private int id; 
    private String name;
    private TaskType type;
    private int priority;
    private LocalDate creationDate;
    private boolean done;
    
    @Override
    public String toString(){
        return id + ", " + name + ", " + type + ", " + priority + ", " + creationDate + ", " + (done ? "wykonane" : "niewykonane");
    }
}
