package com.frank.practice.algorithm;

public class MidSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{3,6,1,10,9,4,12};
        QuickSort selectSort = new QuickSort();
        selectSort.quickSort(arr, 0,arr.length-1);
        for(int i:arr){
            System.out.print(i+",");
        }
        MidSearch midSearch = new MidSearch();
        int indexOf6 = midSearch.midSearch(arr, 6, 0, arr.length-1);
        System.out.println("index of 6 is: " + indexOf6);
    }
    private int midSearch(int[] arr, int value, int low, int high){
        int mid = low + (high-low)/2;
        if(value == arr[mid]){
            return mid;
        }
        else if(value>mid){
            return midSearch(arr, value, mid+1, high);
        } else {
            return midSearch(arr, value, low, mid-1);
        }
    }
}
