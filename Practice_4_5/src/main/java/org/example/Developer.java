package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Developer {
    private String name;
    private String lastName;
    private int salary;
    private Position position;
    private int countOfDoneTask;
    private double score;
    private Task currentTask; //current task
    private List<Task> taskList = new ArrayList<>();

    public Developer(){}
    public Developer(String name, String lastName, int salary)
    {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Developer(String name,
                     String lastName,
                     int salary,
                     Position position,
                     int countOfDoneTask,
                     int score){
       this(name, lastName, salary);
        this.countOfDoneTask = countOfDoneTask;
        this.score = score;
    }

    public void getTaskFromSprintBacklog(SprintBacklog sprintBacklog, int index){
        setCurrentTask(sprintBacklog.getTaskList().get(index));
    }

    public void markTaskAsValidate(Task task){
        try{
            task.setState(State.VALIDATE);
        } catch(NullPointerException exception){
            throw new NullPointerException("You haven't taken a task yet");
        }
    }

    public void setCurrentTask(Task task) {
        this.currentTask = task;
    }
    public Task getCurrentTask(){
        return currentTask;
    }
    public int getStoryPoints(){
        return taskList
                .stream()
                .filter(task -> task.getState() == State.DONE)
                .mapToInt(Task::getStoryPoint)
                .sum();
    }

    public double getScore(){
        try{
            return (double)getStoryPoints() / countOfDoneTask;
        }
        catch(ArithmeticException exception){
            throw new ArithmeticException("Divide on zero");
        }
    }
}
