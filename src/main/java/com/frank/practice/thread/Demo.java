package com.frank.practice.thread;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task(100);
        Thread a = new Thread(new ThreadA(task));
        Thread b = new Thread(new ThreadB(task));
        a.start();
        Thread.sleep(3000);
        b.start();
    }
}
