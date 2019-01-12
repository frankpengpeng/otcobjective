package com.frank.practice.thread;

import java.util.Random;

public class Task {
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private int num;
    public Task(int num) {
        this.num = num;
    }

    public void log(int n){
        Random random = new Random(1000);
        while (n >= 0) {
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程：" + Thread.currentThread().getName() + ":" + n);
            n--;
        }
    }
}
