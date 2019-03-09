package com.frank.practice.leetCode;

import java.lang.reflect.Array;
import java.util.*;

public class FindIntCombinationResult {
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,3,4,5,7};
        FindIntCombinationResult demo = new FindIntCombinationResult();
        List<List<Integer>> res = demo.findResult(arr, 7);
        for (List<Integer> list:res){
            System.out.println(list.toString());
        }
    }
    private List<List<Integer>> findResult(int[] arr, int target){
        Arrays.sort(arr);
        List<Integer> tempResult = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        findAll(arr, 0 , target, tempResult, result);
        return new ArrayList(result);
    }

    private void findAll(int[] arr, int index, int target, List<Integer> tempResult, Set<List<Integer>> result) {
        for(int i= index; i < arr.length;i++ ) {
            if(arr[i] == target){
                tempResult.add(arr[i]);
                result.add(new ArrayList<>(tempResult));
                tempResult.remove(Integer.valueOf(arr[i]));
                break;
            } else if(arr[i] < target){
                tempResult.add(arr[i]);
                findAll(arr, i+1, target -arr[i], tempResult, result);
                tempResult.remove(Integer.valueOf(arr[i]));
            } else {
                break;
            }
        }
    }
}
