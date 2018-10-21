package com.frank.practice.leetCode;

public class PalindromicSubString {
    private String findLongestPalinSubString(String str){
        if(str == null || str.length() < 2){
            return str;
        }
        int max = 0;
        int left;
        int right;
        String subStr = null;
        for(int i = 1; i<str.length() ;i++){
            left = i-1;
            while(left >= 0 && str.charAt(left) == str.charAt(i)){
                left--;
            }
            right = i+1;
            while(right<str.length() && str.charAt(right) == str.charAt(i)){
                right++;
            }
            while(left>=0 && right<str.length() && str.charAt(left) == str.charAt(right)){
                left--;
                right++;
            }
            if(++left<0){
                left = 0;
            }
            if(--right>=str.length()){
                right = str.length()-1;
            }
            if((right-left+1)>max){
                max = right - left + 1;
                subStr = str.substring(left, right);
            }

        }
        return subStr;
    }

    private String findSubStr(String s){
        if(s==null||s.length()<2){
            return s;
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i<s.length();i++){
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len>end-start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);
    }
    private int expandAroundCenter(String s, int left, int right){
        int l = left; int r = right;
        while (l>=0&&r<s.length()&&s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
    public static void main(String[] args) {
        String str= "ababab";
        PalindromicSubString demo = new PalindromicSubString();
        String subStr = demo.findLongestPalinSubString(str);
        System.out.println(subStr);
    }
}
