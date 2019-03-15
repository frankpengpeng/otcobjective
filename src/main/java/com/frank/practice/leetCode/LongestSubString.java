package com.frank.practice.leetCode;

import com.sun.deploy.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
    private String findLongestSubString(String str){
        if(str == null){
            return null;
        }
        if(str.length() ==1){
            return str;
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
        return subStr;
    }

    public static void main(String[] args) {
        String str = "adcdedd";
        LongestSubString testObj = new LongestSubString();
        String subStr = testObj.findLongestSubString(str);
        System.out.println(str + " longest no repeating substr is:" + subStr);
    }

    private String longestNonRepeatedStr(String str){
        if(str == null || str.length() ==1){
            return str;
        }
        char[] charArr = str.toCharArray();
        int max = 0;
        String subStr = "";
        for(int i=1; i<str.length();i++){
            int left = i-1;
            int right = i+i;
            Set<Character> set = new HashSet<>();
            set.add(charArr[i]);
            while (left>=0 && !set.contains(charArr[left])){
                set.add(charArr[left]);
                left--;
            }
            while (right < charArr.length && !set.contains(charArr[right])){
                set.add(charArr[right]);
                right++;
            }
            if(set.size() > max){
                max = set.size();
                subStr = str.substring(left+1,right);
            }
        }
        return subStr;
    }
}
