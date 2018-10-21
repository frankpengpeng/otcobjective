package com.frank.practice.leetCode;

public class AtoInteger {
    public int extractInt(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        char[] charArr = str.toCharArray();
        int k = 0;
        while (k< str.length() && charArr[k] == ' '){
            k++;
        }
        int pOn = 1;
        if(k< str.length() && (charArr[k] == '-' || charArr[k] == '+')){
            pOn = pOn - 2*(charArr[k++] == '-'?1:0);
        }
        int num =0;
        while (k < str.length() && charArr[k] >= '0' && charArr[k]<='9'){
            if(num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && charArr[k] - '0' >7)){
                if(pOn == 1){
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            num = num*10 + (charArr[k++]-'0');
        }
        return num*pOn;
    }

    public static void main(String[] args) {
        String input = "  ";
        AtoInteger atoInteger = new AtoInteger();
        int num = atoInteger.extractInt(input);
        System.out.println(num);
    }
}
