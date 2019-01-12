package com.frank.practice.leetCode;

public class MidOf2SortArrayUseMerge {
    public static void main(String[] args) {
        int[] arrA = new int[]{1,3};
        int[] arrB = new int[] {2,5};
        double mid = getMid(arrA, arrB);
        System.out.println(mid);
    }

    private static double getMid(int[] arrA, int[] arrB) {
        if(arrA == null){
            return getMidOfArr(arrB);
        }
        if(arrB == null) {
            return getMidOfArr(arrA);
        }
        int[] mergedArr = merge(arrA, arrB);
        return getMidOfArr(mergedArr);
    }
    private static double getMidOfArr(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        else if(arr.length == 1){
            return arr[0];
        }
        else if(arr.length %2 ==0) {
            int midInx = (arr.length-1)/2;
            return Double.valueOf(arr[midInx] + arr[midInx+1])/2;
        }
        else {
            int midInx = (arr.length-1)/2;
            return Double.valueOf(arr[midInx]);
        }

    }

    private static int[] merge(int[] arrA, int[] arrB) {
        int[] retArr = new int[arrA.length + arrB.length];
        int i = 0; int j =0; int k=0;
        while (i < arrA.length && j<arrB.length){
            if (arrA[i] <= arrB[j]){
                retArr[k] = arrA[i];
                i++;
                k++;
            }else {
                retArr[k] = arrB[j];
                j++;
                k++;
            }
        }
        while (i<arrA.length){
            retArr[k] = arrA[i];
            k++;
            i++;
        }
        while (j<arrB.length){
            retArr[k] = arrB[j];
            k++;
            j++;
        }
        return retArr;
    }
}
