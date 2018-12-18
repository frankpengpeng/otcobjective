package com.frank.practice.leetCode;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum demo = new ThreeSum();
        List<List<Integer>> res = demo.sum(nums);
        for(List<Integer> list:res){
            System.out.println(list.toString());
        }
    }

    private List<List<Integer>> sum(int[] nums){
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for(int i=0;i<nums.length -2;i++){
            int j=i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[i] + nums[j] + nums[k] ==0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
                else if(nums[i] + nums[j] + nums[k] >0){
                    k--;
                }
                else if(nums[i] + nums[j] + nums[k] <0){
                    j++;
                }
            }
        }
        List<List<Integer>> retList = new ArrayList<>();
        retList.addAll(res);
        return retList;
    }
}
