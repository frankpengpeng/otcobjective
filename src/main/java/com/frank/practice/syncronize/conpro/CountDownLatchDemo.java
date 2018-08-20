package com.frank.practice.syncronize.conpro;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(9);
        for(int i=0;i<10;i++){
            threadPool.execute(new WaitTask(latch));
        }
        for (int i=0;i<10;i++){
            threadPool.execute(new TaskPortion(latch));
        }
        threadPool.shutdown();
    }
}
