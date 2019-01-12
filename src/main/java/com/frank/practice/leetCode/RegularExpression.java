package com.frank.practice.leetCode;

import java.util.regex.Pattern;

public class RegularExpression {
    private static boolean match = false;
    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        boolean result = isMatch(s, p);
        System.out.println(result);

    }

    private static boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        if(p.isEmpty() && s.isEmpty()){
            return true;
        }
        reMatch(0,0, s.toCharArray(), p.toCharArray(),s.length(),p.length());
        return match;
    }

    private static void reMatch(int ti, int pj, char[] text, char[] pattern,int tlen, int plen) {
        if(match){
            return;
        }
        if(pj ==plen){
            if(ti == tlen){
                match = true;
            }
            return;
        }
        if(pattern[pj] == '*'){
            for(int i = 0; i<=tlen-ti;i++){
                reMatch(ti+i, pj+1,text,pattern,tlen,plen);
            }
        }
        else if(pattern[pj] == '.'){
            reMatch(ti,pj+1,text,pattern,tlen,plen);
            reMatch(ti+1, pj+1, text,pattern,tlen,plen);
        }
        else if(ti<tlen && text[ti] == pattern[pj]){
            reMatch(ti+1, pj+1,text, pattern,tlen,plen);
        }
    }
}
