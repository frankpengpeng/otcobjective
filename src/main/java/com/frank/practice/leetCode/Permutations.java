package com.frank.practice.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        Permutations demo = new Permutations();
        List<List<Integer>> res = demo.findPermuations(arr);
        for(List list:res){
            System.out.println(list.toString());
        }
    }

    private  List<List<Integer>> findPermuations(int[] arr) {
        List<Integer> tempResult = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result = findAll(arr, 0,tempResult, result);
        return result;
    }

    private  List<List<Integer>> findAll(int[] arr, int index, List<Integer> tempResult, List<List<Integer>> result) {
        for(int i= index; i< arr.length; i++){
            if(tempResult.contains(arr[i])){
                findAll(arr, index +1,tempResult, result);
            } else {
                tempResult.add(Integer.valueOf(arr[i]));
                if(tempResult.size() == arr.length){
                    result.add(new ArrayList<>(tempResult));
                    tempResult.clear();
                }
                findAll(arr, index +1,tempResult, result);
            }

        }
        return result;
    }
}
