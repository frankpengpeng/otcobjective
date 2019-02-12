package com.frank.practice.leetCode;

import com.sun.deploy.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    private int findLongestSubString(String str){
        if(str == null){
            return 0;
        }
        if(str.length() ==1){
            return 1;
        }
        char[] charArr = str.toCharArray();
        int max=0;
        String subStr="";
        for(int i =1; i < charArr.length;i++){
            int j = i-1;
            int k = i+1;
            Set<Character> strSet = new HashSet<>();
            strSet.add(charArr[i]);
            while (j>=0 && !strSet.contains(charArr[j])){
                strSet.add(charArr[j]);
                j--;
            }
            while (k<charArr.length && !strSet.contains(charArr[k])){
                strSet.add(charArr[k]);
                k++;
            }
            if(strSet.size()>max){
                max = strSet.size();
                subStr = str.substring(j+1,k);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "adcdedd";
        LongestSubString testObj = new LongestSubString();
        int subStr = testObj.findLongestSubString(str);
        System.out.println(str + " longest no repeating substr is:" + subStr);
    }
}
