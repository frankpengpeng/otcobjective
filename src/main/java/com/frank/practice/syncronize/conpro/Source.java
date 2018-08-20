package com.frank.practice.syncronize.conpro;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Source {
    private int size = 0;
    private int max = 10;
    Condition consumerCondition;
    Condition producerCondition;
    Lock lock;

    public Source(Condition consumerCondition, Condition producerCondition, Lock lock) {
        this.consumerCondition = consumerCondition;
        this.producerCondition = producerCondition;
        this.lock = lock;
    }

    public void add(){
        lock.lock();
        try {
            if(size < max){
                size++;
                System.out.println(Thread.currentThread().getName() + "创建一个资源， 当前资源已有：" + size);
                consumerCondition.signalAll();
            } else {
                producerCondition.await();
                System.out.println("资源池已满，创建线程" + Thread.currentThread().getName() + "进入等待");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void remove(){
        lock.lock();
        try {
            if(size>0){
                size--;
                System.out.println(Thread.currentThread().getName() + "删除一个资源， 当前资源数：" + size);
                producerCondition.signalAll();
            } else {
                consumerCondition.await();
                System.out.println("资源池已经空白，删除线程" + Thread.currentThread().getName() + "进入等待");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
