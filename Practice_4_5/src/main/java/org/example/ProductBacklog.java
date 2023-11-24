package org.example;

import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProductBacklog {
    Queue<Task> taskList = new PriorityQueue<Task>(Comparator.comparing(Task::getPriority));
    public ProductBacklog() {
    }

    public void add(Task task){
        taskList.add(task);
    }
    public void delete(){
        taskList.poll();
    }
    public Queue<Task> getTaskList(){
        return taskList;
    }

}
