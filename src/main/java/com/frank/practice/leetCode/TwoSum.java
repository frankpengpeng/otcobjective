package com.frank.practice.leetCode;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] arr = new int[]{2,3,7,6,14};
//        int[] ret = twoSum.twoSum(arr,9);
//        for(int i:ret){
//            System.out.print(i+",");
//        }
        List<List<Integer>> res = twoSum.get2SumsBySort(arr,9);
        for(List l:res){
            System.out.println(l.toString());
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

    public List<List<Integer>> get2Sums(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map =new HashMap<>();
        List<Integer> tempList = new ArrayList<>();
        for(int i = 0; i<nums.length;i++){
            int val = target - nums[i];
            if(map.containsKey(val)){
                tempList.clear();
                tempList.add(i);
                tempList.add(map.get(val));
                res.add(new ArrayList<>(tempList));
            }
            map.put(nums[i],i);
        }
        return res;
    }

    public List<List<Integer>> get2SumsBySort(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> tempRes;
        int left = 0;
        int right = nums.length -1;
        while (left != right && left<nums.length-1 && right>=0){
            if(nums[left] + nums[right] == target) {
                tempRes = new ArrayList<>();
                tempRes.add(nums[left]);
                tempRes.add(nums[right]);
                res.add(tempRes);
                left++;
                right--;
            } else if(nums[left] + nums[right] < target){
                left++;
            } else {
                right--;
            }
        }
        return new ArrayList<>(res);
    }
}
