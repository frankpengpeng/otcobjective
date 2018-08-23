package com.frank.practice.algorithm;

public class MergeSrot {
    public void sort(int[] arr, int low, int high){
        if(low < high) {
            int mid = (high + low) / 2;
            sort(arr, low, mid);
            sort(arr, mid + 1, high);
            merge(arr, low, high, mid);
        }
    }
    public  void merge(int[] arr, int low, int high, int mid){
        int[] temp = new int[high-low+1];
        int k =0;
        int i = low;
        int j = mid+1;
        while (i<=mid && j<=high){
            if(arr[i]<arr[j]){
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        while (i<=mid){
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j<=high){
            temp[k] = arr[j];
            k++;
            j++;
        }
        for (k =0,i= low; i <= high; i++, k++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,6,1,10,9,4,12};
        MergeSrot mergeSrot = new MergeSrot();
         mergeSrot.sort(arr, 0, arr.length -1);
        for(int i:arr){
            System.out.print(i+",");
        }
    }
}
