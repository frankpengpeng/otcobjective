package com.frank.practice.thread;

import java.util.Random;

public class ThreadA implements Runnable {
    private Task task;
    public ThreadA(Task task) {
        this.task = task;
    }
    @Override
    public void run() {
        task.log(task.getNum());
    }
}
