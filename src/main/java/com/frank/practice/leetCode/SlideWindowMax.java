package com.frank.practice.leetCode;

import sun.awt.datatransfer.DataTransferer;

import java.util.*;

public class SlideWindowMax {
    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,2,9,3,6,4,7,-2,-10};
        int k = 3;
        SlideWindowMax demo = new SlideWindowMax();
        Queue<Integer> res = demo.findMax(k, nums);
        for (int i:res){
            System.out.print(i+",");
        }
        Queue<Integer> res1 = demo.findMaxByDeque(k, nums);
        for(int i:res1){
            System.out.print(i+";");
        }
    }

    private Queue<Integer> findMax(int k, int[] nums){
        if(nums == null || nums.length==0){
            return null;
        }
        PriorityQueue<Integer> window= new PriorityQueue<Integer>(k,Collections.reverseOrder());
        Queue<Integer> res = new LinkedList<Integer>();
        for(int i = 0; i<nums.length; i++){
            window.offer(nums[i]);
            if(i>=k){
                window.remove(nums[i-k]);
            }
            if(i+1>=k){
                res.offer(window.peek());
            }
        }
        return res;
    }

    private Queue<Integer> findMaxByDeque(int k, int[] nums){
        if(nums == null || nums.length ==0){
            return new LinkedList<>();
        }
        LinkedList<Integer> deque = new LinkedList<>();
        Queue<Integer> res = new LinkedList<>();
        for(int i=0; i<nums.length; i++) {
            if(!deque.isEmpty() && deque.peekFirst() == i-k){
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }
            deque.offerLast(i);
            if(i+1>=k){
                res.offer(nums[deque.peek()]);
            }
        }
        return res;
    }

}
