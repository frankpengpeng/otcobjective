package com.frank.practice.syncronize.conpro;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TaskPortion implements Runnable {
    private static int counter = 0;
    private final int id= counter++;
    private  static final Random random = new Random(50);
    private CountDownLatch countDownLatch;

    public TaskPortion(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        try {
            doWork();
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt());
        System.out.println(this + "completed");
    }

    @Override
    public String toString() {
        return "TaskPortion{" +
                "id=" + id +
                '}';
    }
}
