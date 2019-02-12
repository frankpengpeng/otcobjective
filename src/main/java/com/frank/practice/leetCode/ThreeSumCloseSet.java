package com.frank.practice.leetCode;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSumCloseSet {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2};
        ThreeSumCloseSet demo = new ThreeSumCloseSet();
        int res = demo.sum(nums, 0);
        System.out.println(res);
    }

    private int sum(int[] nums, int target) {
        int retSum = 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 2; i < nums.length; i++){
            int l = 0;
            int r = i -1;
            while (l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if(Math.abs(sum - target) == 0) {
                    return sum;
                }
                int diff = Math.abs(sum - target);
                if(diff < min) {
                    min = diff;
                    retSum = sum;
                    continue;
                }
                if(sum > target){
                    r--;
                }else {
                    l++;
                }
            }
        }
        return retSum;
    }
}
