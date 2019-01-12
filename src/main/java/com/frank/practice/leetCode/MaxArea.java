package com.frank.practice.leetCode;

import java.util.Date;

public class MaxArea {
    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        Date t1 = new Date();
        int maxArea = maxArea(arr);
        Date t2 = new Date();
        System.out.println("maxArea spend time:" + (t2.getTime() - t1.getTime()));

        Date t3 = new Date();
        int maxArea2 = maxArea2(arr);
        Date t4 = new Date();
        System.out.println("maxArea spend time:" + (t4.getTime() - t3.getTime()));


    }
    public static int maxArea(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int max =0;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                int area = (j-i)*Math.min(arr[i], arr[j]);
                if(area > max) {
                    max = area;
                }
            }
        }
        return max;
    }
    public static int maxArea2(int[] arr){
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int left = 0;
        int right = arr.length -1;
        int max = 0;
        while (left < right){
            int area = (right - left)* Math.min(arr[left], arr[right]);
            if(area > max) {
                max = area;
            }
            if(arr[left] >arr[right]){
                right--;
            }
            else {
                left++;
            }
        }
        return max;
    }
}
