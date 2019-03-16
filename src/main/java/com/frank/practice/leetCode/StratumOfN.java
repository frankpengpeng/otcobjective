package com.frank.practice.leetCode;

public class StratumOfN {
    public static void main(String[] args) {
        StratumOfN demo = new StratumOfN();
        int res = demo.getStratum(5);
        System.out.println(res);
    }

    private int getStratum(int n) {
        if(n == 0) {
            return 0;
        }
        else if(n ==1){
            return 1;
        }
        return n*getStratum(n-1);
    }
}
