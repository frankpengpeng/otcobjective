package com.frank.practice.syncronize.conpro;

import java.util.List;

public class Productor implements Runnable {
    private Source source;

    public Productor(Source source) {
        this.source = source;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            source.add();
        }
    }
}
