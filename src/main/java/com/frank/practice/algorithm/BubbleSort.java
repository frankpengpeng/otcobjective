package com.frank.practice.algorithm;

public class BubbleSort {
    public int[] sort(int[] arr){
        int temp;
        for(int i= 0; i<arr.length;i++){
            for(int j = i; j<arr.length; j++){
                if(arr[j] < arr[i]){
                    temp = arr[j];
                    arr[j]= arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    public int[] improvedSort(int[] arr){
       int temp;
       int i = arr.length -1;
       int pos;
       while (i>0){
           pos=0;
           for (int j = 0; j < i ; j++) {
               if(arr[j]> arr[j+1]){
                   pos = j;
                   temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
               }
           }
           i = pos;
       }
       return arr;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3,6,1,10,9,4,12};
        BubbleSort bubbleSort = new BubbleSort();
        arr = bubbleSort.improvedSort(arr);
        for(int i:arr){
            System.out.print(i+",");
        }
    }
}
