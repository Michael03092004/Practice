package org.example;

import org.example.First.PrintServer;
import org.example.First.Printer;
import org.example.First.User;
import org.example.Second.BlockingStack;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static volatile boolean canDestroyPutin;

    public static void main(String[] args) throws InterruptedException {
        //First task

//        PrintServer printServer = new PrintServer();
//
//        new Thread(new Printer(printServer)).start();
//        new Thread(new Printer(printServer)).start();
//
//        new Thread(new User(printServer)).start();
//        new Thread(new User(printServer)).start();
//        new Thread(new User(printServer)).start();
//        new Thread(new User(printServer)).start();

        //Second task

//        Stack<Integer> stack = new Stack<>();
//        BlockingStack<Integer> blockingStack = new BlockingStack<>(stack);
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                IntStream.rangeClosed(1,10).forEach(blockingStack::push);
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (blockingStack){
//                    IntStream.rangeClosed(1, 5).forEach(n -> {
//                        blockingStack.pop();
//                    });
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (blockingStack){
//                    IntStream.rangeClosed(1, 5).forEach(n -> {
//                        blockingStack.pop();
//                    });
//                }
//            }
//        }).start();

        //third task

        Object lock = new Object();

        Thread blockedThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Blocked Thread: Acquiring lock");
                try {
                    // Simulate some work
                    Thread.sleep(1000);
                    System.out.println("Blocked Thread: Waiting for a notification");
                    lock.wait(); // Thread will be blocked here until notified
                    System.out.println("Blocked Thread: Resumed after notification");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread notifyingThread = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Notifying Thread: Acquiring lock");
                // Simulate some work
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Notifying Thread: Notifying the blocked thread");
                lock.notify(); // Notifying the blocked thread
            }
        });
        //NEW state for blockedThread cause it wasn't run
        System.out.println(blockedThread.getState());
        blockedThread.start();
        //RUNNABLE state for blockedThread cause it was started
        System.out.println(blockedThread.getState());
        Thread.sleep(2);
        notifyingThread.start();

        //TIME_WAITING state for blockedThread cause Thread is sleeping for 2 milliseconds
        System.out.println(blockedThread.getState());
        //Obviously RUNNABLE
        System.out.println(notifyingThread.getState());



    }
}