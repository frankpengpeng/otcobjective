package com.frank.practice.leetCode;

public class MidOf2SortedArrary {
    int[] arrA = new int[]{1,3,5,7,9};
    int[] arrB = new int[] {2,4,6,8,11};

    public static void main(String[] args) {

    }
    private static int getMid(int[] arrA, int[] arrB){
        if(arrA == null || arrA.length ==0){
            return getMidOfArr(arrB);
        } else if(arrB == null || arrB.length == 0) {
            return getMidOfArr(arrA);
        }

        int heapSize = (arrA.length + arrB.length)/2;
        int[] smallHeadHeap = new int[heapSize];
        int[] bigHeadHeap = new int[heapSize];

        smallHeadHeap[0] = arrB[0];
        bigHeadHeap[0] = arrA[0];
        int i = 1, j=1;
        while (i<arrA.length){
            if(arrA[i] >= smallHeadHeap[0]) {
                buildSmallHeadHeap(smallHeadHeap, arrA[i]);
            } else {
                buildBigHeadHeap(bigHeadHeap, arrA[i]);
            }
        }
        return 0;
    }
    private static int getMidOfArr(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        else if(arr.length == 1){
            return arr[0];
        }
        else if(arr.length %2 ==0) {
            int midInx = (arr.length-1)/2;
            return (arr[midInx] + arr[midInx+1])/2;
        }
        else {
            int midInx = (arr.length-1)/2;
            return arr[midInx];
        }

    }
    private static int buildSmallHeadHeap(int[] arr, int num) {
        return arr[0];
    }
    private static int buildBigHeadHeap(int[] arr, int num) {
        return arr[0];
    }
}
