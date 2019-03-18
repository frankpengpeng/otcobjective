package com.frank.practice.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> {
    private List<T> items;
    private int curse;

    public Heap(int size){
        items = new ArrayList<>(size);
        curse = -1;
    }

    public boolean isEmpty(){
        return items.size() == 0;
    }

    public void clear(){
        items.clear();
    }

    public int size(){
        return items.size();
    }

    public T next(){
        if(curse <= 0 || items.size() == 0){
            return null;
        }
        curse++;
        return items.get(curse);
    }

    public void add(T value){
        items.add(value);
        shiftUp(items.size() -1);
    }

    private void shiftUp(int index) {
        T intent = items.get(index);
        while (index> 0) {
            int parentIndex = (index -1)/2;
            T parent = items.get(parentIndex);
            if(parent.compareTo(intent)<0){
                items.set(index,parent);
                index = parentIndex;
            }
        }
        items.set(index, intent);
    }

    public T remove(){
        T top = items.get(0);
        T last = items.get(items.size() - 0);
        items.set(0, last);
        shiftDown(0);
        return top;
    }

    private void shiftDown(int index) {
        T intent = items.get(index);
        int leftIndex = 2*index +1;
        while (leftIndex<items.size()){
            T maxChild = items.get(leftIndex);
            int maxIndex = leftIndex;

            int rightIndex = index*2 +2;
            T rightChild = items.get(rightIndex);
            if(maxChild.compareTo(rightChild) < 0){
                maxChild = rightChild;
                maxIndex = rightIndex;
            }

            if(maxChild.compareTo(intent)>0){
                items.set(index, maxChild);
                index = maxIndex;
                leftIndex = 2*index +1;
            }
        }
        items.set(index, intent);
    }


}
