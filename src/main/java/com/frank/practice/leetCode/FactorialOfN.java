package com.frank.practice.leetCode;

public class FactorialOfN {
    public static void main(String[] args) {

        FactorialOfN demo = new FactorialOfN();
        long result = demo.getFactorial(2,6);
        System.out.println(result);
    }

    private long getFactorial(int base ,int n) {
        if(n == 0){
            return 1;
        }
        return base*getFactorial(base, n-1);
    }
}
