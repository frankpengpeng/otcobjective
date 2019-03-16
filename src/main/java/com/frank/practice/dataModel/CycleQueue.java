package com.frank.practice.dataModel;

public class CycleQueue {
    private int front;
    private int rear;
    private int maxLen;
    private int[] dataList;
    public CycleQueue(){
        dataList = new int[maxLen];
        front = 0;
        rear = 0;
    }

    private boolean isEmpty() {
        if(front == rear) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isFull() {
        if((rear+1)%maxLen==front){
            return true;
        }
        else {
            return false;
        }
    }

    private void getFrontOfQueue(int front){
        if(!isEmpty()){
            front = dataList[(front+1)/maxLen];
        }
        else {
            return;
        }
    }

    private void inQueue(int inData){
        if(!isFull()) {
            rear = (rear +1)/maxLen;
            this.dataList[rear] = inData;
        }
    }

    private void outData(){
        if(!isEmpty()){
            front = (front+1)/maxLen;
        }
        else {
            return;
        }
    }
}
