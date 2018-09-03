package com.frank.practice.algorithm;

public class HeapSort {

    private void adjustHeap(int[] arr, int parent, int length){
        int temp = arr[parent];
        int child = parent*2+1;
        while (child<length){
            if(child+1<length && arr[child]<arr[child+1]){
                child++;
            }
            if(temp>arr[child]){
                break;
            }
            arr[parent] = arr[child];
            parent = child;
            child = child*2+1;
        }
        arr[parent] = temp;
    }

    private void heapSort(int[] arr, int length){
        for(int i=length/2;i>=0;i--){
            adjustHeap2(arr, i, length-1);
        }
        for(int j = length-1; j>=0;j--){
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0,j);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,6,1,10,9,4,12};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr,arr.length);
        for(int i:arr){
            System.out.print(i+",");
        }
    }

    private void adjustHeap2(int[] arr, int head, int len){
        int left, right, j;
        while ((left = 2*head+1) < len){
            right = left+1;
            j =left;
            if(j<len && arr[left]<arr[right]){
                j++;
            }
            if(arr[head]<arr[j]){
                int temp = arr[head];
                arr[head] = arr[j];
                arr[j] = temp;
            } else {
                break;
            }
            head=j;
        }
    }
}
