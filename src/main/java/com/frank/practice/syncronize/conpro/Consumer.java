package com.frank.practice.syncronize.conpro;

public class Consumer implements Runnable{
    private Source source;

    public Consumer(Source source) {
        this.source = source;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep((long) (1000 * Math.random()));
                source.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
