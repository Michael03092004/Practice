package org.example.Second;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingStack<T> {
    private final Stack<T> stack;
    private final Lock locker;
    private final Condition isFull;
    private final Condition isEmpty;
    public static final int CAPACITY = 4;

    public BlockingStack(Stack<T> stack) {
        this.stack = stack;
        locker = new ReentrantLock();
        isFull = locker.newCondition();
        isEmpty = locker.newCondition();
    }

    public void push(T t) {
        locker.lock();

        try {
            while (stack.size() == BlockingStack.CAPACITY) {
                isFull.await();
            }
            stack.push(t);
            System.out.println(t + " number was added");
            isEmpty.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }

    public T pop() {
        T el = null;

        locker.lock();
        try {
            while (stack.isEmpty()) {
                isEmpty.await();
            }
            el = stack.pop();
            System.out.println(el + " number was taken from stack");
            isFull.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }

        return el;
    }

    public Stack<T> getStack(){
        return stack;
    }

}
