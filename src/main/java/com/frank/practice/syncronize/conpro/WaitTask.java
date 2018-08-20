package com.frank.practice.syncronize.conpro;

import java.util.concurrent.CountDownLatch;

public class WaitTask implements Runnable {
    private static int counter = 0;
    private final int id=counter++;
    private CountDownLatch countDownLatch;

    public WaitTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        try {
            countDownLatch.await();
            System.out.println("latch passed for" + this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "WaitTask{" +
                "id=" + id +
                '}';
    }
}
