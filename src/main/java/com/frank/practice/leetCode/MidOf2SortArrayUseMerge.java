package com.frank.practice.leetCode;

public class MidOf2SortArrayUseMerge {
    public static void main(String[] args) {
        int[] arrA = new int[]{1,3};
        int[] arrB = new int[] {2,5};
        double mid = getMid(arrA, arrB);
        System.out.println(mid);
    }

    private static double getMid(int[] arrA, int[] arrB) {
        if(arrA == null) {
            return getMidOfArr(arrB);
        }
        if(arrB == null){
            return getMidOfArr(arrA);
        }
        int[] mergedArr = merge(arrA, arrB);
        return getMidOfArr(mergedArr);
    }

    private static int[] merge(int[] arrA, int[] arrB) {
        int[] res = new int[arrA.length+arrB.length];
        int left = 0;
        int right = 0;
        int k =0;
        while (left<arrA.length && right<arrB.length){
            if(arrA[left] < arrB[right]){
                res[k] = arrA[left];
                left++;
                k++;
            } else {
                res[k] = arrB[right];
                right++;
                k++;
            }
        }
        while (left<arrA.length){
            res[k] = arrA[left];
            k++;
            left++;
        }
        while (right<arrB.length){
            res[k] = arrB[right];
            right++;
            k++;
        }
        return res;
    }

    private static double getMidOfArr(int[] arrA) {
        if(arrA == null || arrA.length ==0) {
            return 0;
        }
        if(arrA.length == 1){
            return arrA[0];
        }
        if(arrA.length%2 == 0) {
            int midIndex = (arrA.length-1)/2;
            return arrA[midIndex];
        } else {
            int midIndex = (arrA.length-1)/2;
            return Double.valueOf(arrA[midIndex] + arrA[midIndex+1])/2;
        }
    }

}
