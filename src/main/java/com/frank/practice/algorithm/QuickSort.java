package com.frank.practice.algorithm;

public class QuickSort {
    public void quickSort(int[] arr, int left, int right){
        if(arr.length==0 || left>=right){
            return;
        }
        int baseElement = arr[left];
        int i=left,j=right;
        while(i<j){
            while(i<j&&arr[j]>=baseElement){
                j--;
            }
            while (i<j&&arr[i] <= baseElement){
                i++;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = baseElement;
        quickSort(arr, left, i-1);
        quickSort(arr, i+i,right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,6,1,10,9,4,12};
        QuickSort selectSort = new QuickSort();
        selectSort.quickSort(arr, 0,arr.length-1);
        for(int i:arr){
            System.out.print(i+",");
        }
    }

    private void quickSort2(int arr[], int left, int right){
        if(left >= right){
            return;
        }
        int i = left;
        int j = right;
        int temp = arr[left];
        while (i<j){
            while(i<j&&arr[j]>=temp){
                j--;
            }
            while (i<j && arr[i] <=temp){
                i++;
            }
            if(i<j){
                int x = arr[i];
                arr[i] = arr[j];
                arr[j] = x;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quickSort2(arr, left, i-1);
        quickSort2(arr, i+1, right);
    }

    private void quickSort3(int[] arr, int left, int right){
        if(left>=right){
            return;
        }
        int i = left;
        int j = right;
        int temp = arr[left];
        while (i<j){
            while (i<j && arr[i] <= temp){
                i++;
            }
            while (i<j && arr[j] >= temp){
                j--;
            }
            if(i<j){
                int x = arr[i];
                arr[i] = arr[j];
                arr[j] = x;
            }
        }
        arr[left] = arr[right];
        arr[right] = temp;
        quickSort3(arr, left, i-1);
        quickSort3(arr, i+i, right);
    }
}
