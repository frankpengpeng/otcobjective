package com.frank.practice.leetCode;

import org.springframework.util.CollectionUtils;

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};
        Permutations demo = new Permutations();
        List<List<Integer>> res = demo.findPermuations(arr);
        for(List list:res){
            System.out.println(list.toString());
        }
    }

    private  List<List<Integer>> findPermuations(int[] arr) {
        List<Integer> tempResult = new ArrayList<>();
        Set<List<Integer>> result = new HashSet<>();
        findAll(0,arr, result);
        return new ArrayList<>(result);
    }

    private  void findAll(int index, int[] arr, Set<List<Integer>> result) {
        if(index == arr.length){
            List<Integer> tempRes = new ArrayList<>();
            for(int e:arr){
                tempRes.add(Integer.valueOf(e));
            }
            result.add(tempRes);
        }
        for(int j= index; j< arr.length; j++){
            int temp = arr[j];
            arr[j] = arr[index];
            arr[index] = temp;

            findAll(index +1, arr, result);

            temp = arr[j];
            arr[j] = arr[index];
            arr[index] = temp;
        }
    }

    private  void findPermutations(int index, int[] arr, Set<List<Integer>> result, List<Integer> tempResult) {
        if(index == arr.length) {
            tempResult = new ArrayList<>();
            for(int e:arr){
                tempResult.add(Integer.valueOf(e));
            }
            result.add(tempResult);
        }
        for(int j = index; j<arr.length; j++){
            int temp = arr[j];
            arr[j] = arr[index];
            arr[index] = temp;
            findPermutations(index +1, arr, result, tempResult);

            temp = arr[j];
            arr[j] = arr[index];
            arr[index] = temp;
        }
    }
}
