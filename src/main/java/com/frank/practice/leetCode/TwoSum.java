package com.frank.practice.leetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] arr = new int[]{2,3,7,10,14};
        int[] ret = twoSum.twoSum(arr,9);
        for(int i:ret){
            System.out.print(i+",");
        }
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i <nums.length;i++){
            int val = target - nums[i];
            if(map.containsKey(val)){
                return new int[]{i, map.get(val)};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
