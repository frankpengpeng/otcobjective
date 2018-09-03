package com.frank.practice.algorithm;

import java.util.Arrays;

public class FibonanceSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{3,6,1,10,9,4,12};
        QuickSort selectSort = new QuickSort();
        selectSort.quickSort(arr, 0,arr.length-1);
        for(int i:arr){
            System.out.print(i+",");
        }
        FibonanceSearch search = new FibonanceSearch();
        int indexOf6 = search.search(arr, 6);
        System.out.println("index of 6 is: " + indexOf6);
    }
    private int search(int[] arr, int value)
    {
        if(arr==null || arr.length==0){
            return -1;
        } else {
            int[] fb= makeFibonanciArray(20);
            int length = arr.length;
            int k = 0;
            while(length> fb[k]-1){
                k++;
            }
            int[] tmp = Arrays.copyOf(arr,fb[k] -1);
            for(int i=length;i<tmp.length ;i++){
                if(i>=length){
                    tmp[i] = arr[length -1];
                }
            }
            int low = 0;
            int high = arr.length -1;
            while (low <=high){
                int mid = low + fb[k-1] -1;
                if(tmp[mid]>value){
                    high = mid -1;
                    k=k-1;
                } else if(tmp[mid] < value){
                    low = mid+1;
                    k=k-2;
                } else {
                    if(mid<=high){
                        return mid;
                    } else {
                        return high;
                    }
                }
            }
        }
        return -1;
    }
    private int[] makeFibonanciArray(int length){
        int[] arrary = null;
        if(length>2){
            arrary = new int[length];
            arrary[0] = 1;
            arrary[1] =1;
            for(int i = 2; i< length; i++){
                arrary[i] = arrary[i-1]+arrary[i-2];
            }
        }
        return arrary;
    }
}
