package com.frank.practice.algorithm;

public class SelectSort {
    public int[] sort(int[] arr){
        int temp;
        int pos;
        for (int i = 0; i < arr.length; i++) {
            pos = i;
            for (int j = i; j <arr.length-1 ; j++) {
                if(arr[j]<arr[pos]){
                    pos = j;
                }
            }
            if(pos != i){
                temp = arr[pos];
                arr[pos] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,6,1,10,9,4,12};
        SelectSort selectSort = new SelectSort();
        arr = selectSort.sort(arr);
        for(int i:arr){
            System.out.print(i+",");
        }
    }
}
