package com.frank.practice.algorithm;

public class InsertSort {
    public int[] sort(int[] arr){
        int temp;
        for (int i = 1; i <arr.length ; i++) {
            for (int j = i; j >0 ; j--) {
                if(arr[j] < arr [j-1]){
                    temp= arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] =temp;
                }
            }
        }
        return arr;
    }

    public int[] improvedSort(int[] arr){
        int temp;
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while(j>0 && arr[j] < arr[j-1]){
                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3,6,1,10,9,4,12};
        InsertSort insertSort = new InsertSort();
        arr = insertSort.improvedSort(arr);
        for(int i:arr){
            System.out.print(i+",");
        }
    }
}
