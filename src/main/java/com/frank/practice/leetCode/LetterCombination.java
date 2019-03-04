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
        Map<Integer,String> numToChars = new HashMap<>();
        numToChars.put(0,"");
        numToChars.put(1,"");
        numToChars.put(2,"abc");
        numToChars.put(3,"def");
        numToChars.put(4,"ghi");
        numToChars.put(5,"jkl");
        numToChars.put(6,"mno");
        numToChars.put(7,"pqrs");
        numToChars.put(8,"tuv");
        numToChars.put(9,"wxyz");
        List<String> result = new ArrayList<>();
        if(digits == null ||digits.length() ==0) return result;
        combineLetters(digits, numToChars, result, "",0);
        return result;
    }

    private void combineLetters(String digits, Map<Integer,String> numToChars, List<String> result, String letter, int index) {

            Integer num = Integer.parseInt(String.valueOf(digits.charAt(index)));
            String numStr = numToChars.get(num);
            if (index == digits.length()){
                result.add(letter);
                return;
            }
            for(char cur:numToChars.get(digits.charAt(index) - '2').toCharArray()) {
                combineLetters(digits, numToChars, result, letter+cur, index + 1);
            }

    }

    private String[] strConst = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> strList = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if(digits != null && digits.length() != 0) process(digits, 0, "");
        return strList;
    }

    public void process(String digits, int pos, String str) {
        if(pos == digits.length()) {
            strList.add(str);
            return;
        };
        for(char cur : strConst[digits.charAt(pos) - '2'].toCharArray()) process(digits, pos + 1, str + cur);
    }
}