package com.frank.practice.leetCode;

public class PalindNumber {
    private boolean isPalind(int num){
        if(num < 0){
            return  false;
        }
        int rev = 0;
        int temp=num;
        while(temp >0){
            rev = rev*10 +temp%10;
            temp = temp/10;
        }
        return rev == num;
    }

    public static void main(String[] args) {
        PalindNumber pn = new PalindNumber();
        System.out.println(pn.isPalind(10));
    }
}
