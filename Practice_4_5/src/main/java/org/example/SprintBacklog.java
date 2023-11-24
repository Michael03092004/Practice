package org.example;

import java.util.ArrayList;
import java.util.List;

public class SprintBacklog {
    private final List<Task> taskList;
    public SprintBacklog(){
        taskList = new ArrayList<Task>();
    }
    public SprintBacklog(List<Task> taskList){
        this.taskList = taskList;
    }

    public void add(Task task){
        taskList.add(task);
    }

    public void delete(Task task){
        taskList.remove(task);
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public int getVelocity(){
        return taskList.size();
    }

}
