package org.example.Third;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestThreadState {
    private Thread thread;
    public TestThreadState(Thread thread){
        this.thread = thread;
    }

    public void NewStateTest(){
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
            }
        });
        System.out.println(thread.getState());
    }

    public void RunnableStateTest(){
        thread.start();
        System.out.println(thread.getState());
    }

    public void WaitingStateTest() throws InterruptedException {
        Lock locker = new ReentrantLock();
        Condition condition = locker.newCondition();

        locker.lock();
        try{
            for(int i = 0; i < 3; i++){
                condition.wait();
            }
        } finally{
            locker.unlock();
        }
    }

    public void WaitingTimeStateTest(){

    }

    public void BlockedStateTest(){

    }

    public void TerminatedStateTest(){

    }

    public Thread getThread(){
        return thread;
    }
}
