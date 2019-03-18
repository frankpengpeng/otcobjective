package com.frank.practice.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {
    public static void main(String[] args) {
        LetterCombination demo = new LetterCombination();
        List<String> result = demo.combineLetters("23");
        System.out.println(result);

    }
    private List<String> combineLetters(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null ||digits.length() ==0) return result;
        result = combinateLetters(digits);
        return result;
    }



    private String[] strConst = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> combinateLetters(String digits) {
        List<String> res = new ArrayList<>();
        if (digits != null && digits.length() != 0) {
            doCombinate(res, digits, 0, "");
        }
        return res;
    }

    private void doCombinate(List<String> res, String digits, int i, String s) {
        if(i == digits.length()){
            res.add(s);
            return;
        }
        for(char c:strConst[digits.charAt(i)- '2'].toCharArray()){
            doCombinate(res, digits, i+1, s+c);
        }
    }
}