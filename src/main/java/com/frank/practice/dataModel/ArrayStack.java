package com.frank.practice.dataModel;

public class ArrayStack<T> {
    private T[] dataArr;
    private int size;
    private static final int DEFAULT_SIZE = 6;

    public ArrayStack(int size){
        clean();
    }

    private void clean() {
        size = 0;
        ensureCapacity(DEFAULT_SIZE);
    }

    private void ensureCapacity(int newSize) {
        if(newSize < size){
            return;
        }
        T[] oldData = dataArr;
        T[] newArr = (T[])new Object[newSize];
        for(int i = 0; i< oldData.length;i++) {
            newArr[i] = oldData[i];
        }
    }

    private int size(){
        return size;
    }

    private boolean isEmpty(){
        return size() == 0;
    }

    private void push(T value){
        if(dataArr.length == size) {
            ensureCapacity(size * 2);
        }
        dataArr[size++] = value;
    }

    private T pop(){
        if(isEmpty()){
            return null;
        }
        T data = dataArr[size -1];
        dataArr[--size] = null;
        return data;
    }

    private T peek(){
        if(isEmpty()){
            return null;
        }
        T data = dataArr[size -1];
        return data;
    }
}
