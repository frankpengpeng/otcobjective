package com.frank.practice.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String roman = "LIV";
        int num = romanInteger(roman);
        System.out.println(num);
    }

    private static int romanInteger(String roman) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int num = 0;
        int pre = 0;
        for (int i = roman.length()-1; i >=0 ; i--) {
            int temp = map.get(roman.charAt(i));
            if(temp<pre){
                num -= temp;
            } else {
                num += temp;
            }
            pre = temp;
        }
        return num;
    }
}
