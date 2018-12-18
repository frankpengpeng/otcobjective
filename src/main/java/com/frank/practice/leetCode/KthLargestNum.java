package com.frank.practice.leetCode;

import com.sun.org.apache.xalan.internal.xsltc.dom.MultiValuedNodeHeapIterator;

import java.util.PriorityQueue;

public class KthLargestNum {
    private PriorityQueue<Integer> que = new PriorityQueue<>();
    private int k;
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,6,1,9,8,10};
        KthLargestNum demo = new KthLargestNum(4, nums);
        System.out.println(demo.add(1));
        System.out.println(demo.add(7));
        System.out.println(demo.add(19));
    }

    KthLargestNum(int k,int[] nums){
        this.k = k;
        for(int i:nums){
            que.offer(i);
            if(que.size()>k){
                que.poll();
            }
        }
    }

    int add(int num){
        que.offer(num);
        if(que.size()>k){
            que.poll();
        }
        return que.peek();
    }
}
