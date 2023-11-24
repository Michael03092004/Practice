package org.example.First;

public class Printer implements Runnable {
    private final PrintServer printServer;

    public Printer(PrintServer printServer) {
        this.printServer = printServer;
    }

    @Override
    public void run() {
        try {
            while(true){
                getTask();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getTask() throws InterruptedException {
        synchronized (printServer) {
            if (printServer.getTasksQueue().isEmpty()) {
                System.out.println("Printer is waiting...");
                printServer.wait()  ;
            }
            else{
                System.out.printf("Task was taken from user #%d \n",
                        printServer.getTasksQueue().element().getOwner().getUserId());
                printServer.getTasksQueue().poll();
                PrintServer.TAKEN_TASK_COUNT++;
                printServer.notifyAll();
            }

        }

    }
}

