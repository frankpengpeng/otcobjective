package com.frank.practice.leetCode;

public class ClimbStair {
    public static void main(String[] args) {

        ClimbStair demo = new ClimbStair();
        int res = demo.doClimb(9);
        System.out.println(res);
    }

    private int doClimb(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        return doClimb(n-1) + doClimb(n-2);
    }
}
