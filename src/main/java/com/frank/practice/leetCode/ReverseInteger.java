package com.frank.practice.leetCode;

public class ReverseInteger {
    public int reverse(int in,StringBuilder sb){
        if(in < 0){
            sb.append("-");
            int positValue = Math.abs(in);
            return reverse(positValue,sb);
        }

        if(in <10){
            return Integer.valueOf(sb.append(in).toString()).intValue();
        }
        int mod = in % 10;
        int div = in/10;
        sb.append(mod);
        return reverse(div,sb);
    }

    public static void main(String[] args) {
        int testNum= -1790268791;
        ReverseInteger reverseInteger =  new ReverseInteger() ;
        StringBuilder sb = new StringBuilder();
        reverseInteger.reverse(testNum, sb);
        System.out.println(sb.toString());

        int reverseInt = reverseInteger.reverseInt(testNum);
        System.out.println(reverseInt);
    }

    public int reverseInt(int num){
        int rev = 0;
        int x = num;
        while (x != 0){
            int pop = x%10;
            x /= 10;
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop >7)) return 0;
            if(rev< Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE && pop <-8)) return 0;
            rev = rev*10 + pop;
        }
        return rev;
    }
}
