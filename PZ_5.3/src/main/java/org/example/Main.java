package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static int a = 0;
    private static final Object lock = new Object();

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


        Thread thread = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        System.out.println("Thread state: " + thread.getState());

        thread.start();

        System.out.println("Thread state: " + thread.getState());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread state: " + thread.getState());

        Thread blockedThread = new Thread(() -> {
            synchronized (lock) {
            }
        });

        blockedThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread state: " + blockedThread.getState());

        try {
            thread.join();
            blockedThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread state: " + thread.getState());
    }
}