package org.example.First;

import java.util.LinkedList;
import java.util.Queue;

public class PrintServer{
    private final Queue<Task> tasksQueue = new LinkedList<>();
    public static int CAPACITY = 10;
    public static int USER_ID;
    public static int TOTAL_TASK_COUNT;
    public static int TAKEN_TASK_COUNT;

    public Queue<Task> getTasksQueue(){
        return tasksQueue;
    }


}
