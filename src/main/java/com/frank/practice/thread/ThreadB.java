package com.frank.practice.thread;

public class ThreadB implements Runnable {
    private Task task;
    public ThreadB(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        task.log(task.getNum());
    }
}
