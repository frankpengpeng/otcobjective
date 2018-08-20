package com.frank.practice.syncronize.conpro;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProConDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition consumerCondition = lock.newCondition();
        Condition producerCondition = lock.newCondition();
        Source source = new Source( consumerCondition, producerCondition,lock);
        Productor productor = new Productor(source);
        Consumer consumer1 = new Consumer(source);
        Consumer consumer2 = new Consumer(source);
        Consumer consumer3 = new Consumer(source);
        new Thread(productor).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
        new Thread(consumer3).start();
    }
}
