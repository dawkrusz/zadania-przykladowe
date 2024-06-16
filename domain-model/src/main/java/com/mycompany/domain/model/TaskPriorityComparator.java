/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domain.model;

import java.util.Comparator;
/**
 *
 * @author dawid
 */
public class TaskPriorityComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2){
        return Integer.compare(t2.getPriority(), t1.getPriority());
    }
}
