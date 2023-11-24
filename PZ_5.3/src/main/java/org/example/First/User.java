package org.example.First;

import java.security.SecureRandom;

public class User implements Runnable{
    private final int userId;
    private final int countOfTasks;
    private int sentTaskCount;
    private final PrintServer printServer;

    public User(PrintServer printServer) {
        userId = ++PrintServer.USER_ID;
        this.printServer = printServer;
        countOfTasks = new SecureRandom().nextInt(2, 6);
        sentTaskCount = 0;
        PrintServer.TOTAL_TASK_COUNT += countOfTasks;
    }

    @Override
    public void run() {
        try{
            sendTasks();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

    }
    public void sendTasks() throws InterruptedException{
        synchronized (printServer){
            while(sentTaskCount != countOfTasks){
                Task newTask = new Task(this);
                if(printServer.getTasksQueue().size() == PrintServer.CAPACITY){
                    printServer.wait();
                    System.out.printf("User #%d is waiting, %d left to be sent \n", userId,
                            newTask.getOwner().countOfTasks-sentTaskCount);
                }
                printServer.getTasksQueue().add(newTask);
                System.out.printf("Task was sent from user #%d \n", getUserId());
                ++sentTaskCount;
            }
            printServer.notifyAll();
        }
    }

    public int getUserId(){
        return userId;
    }
}
