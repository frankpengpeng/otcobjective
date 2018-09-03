package com.frank.practice.algorithm;

public class InsertSearch {
    private int insertSearch(int[] arr, int value, int low, int high){
        int mid = low + (value - arr[low])/(arr[high]-arr[low])*(high-low);
        if(arr[mid] == value){
            return mid;
        }else if(arr[mid]>value){
            return insertSearch(arr, value, low, mid-1);
        }else {
            return insertSearch(arr, value, mid+1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,6,1,10,9,4,12};
        QuickSort selectSort = new QuickSort();
        selectSort.quickSort(arr, 0,arr.length-1);
        for(int i:arr){
            System.out.print(i+",");
        }
        InsertSearch insertSearch = new InsertSearch();
        int indexOf6 = insertSearch.insertSearch(arr, 6, 0, arr.length-1);
        System.out.println("index of 6 is: " + indexOf6);
    }
}
