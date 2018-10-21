package com.frank.practice.leetCode;

public class RegValidation {
    private boolean isMatch(String str, String reg){
        int regLeft = 0;
        int strLeft = 0;
        int regRight = reg.length() -1;
        int strRight = str.length() -1;
        while (strLeft < str.length() && regLeft<reg.length()){
            if(str.charAt(strLeft) == reg.charAt(regLeft) || reg.charAt(regLeft) == '.'){
                strLeft++;
                regLeft++;
                continue;
            }
        }
        if(strLeft == str.length()){
            if(regLeft == reg.length()){
                return true;
            } else {
                if(reg.charAt(regLeft) != '*'){
                    return false;
                } else{
                    while(strRight>strLeft &&
                            regRight > regLeft &&
                            (str.charAt(strRight) == reg.charAt(regRight) ||
                                    reg.charAt(regRight) == '.' ||
                                    reg.charAt(regRight) == '*')){
                        strRight--;

                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RegValidation validation = new RegValidation();
        boolean isMatch = validation.isMatch("abcde", "*a");
        System.out.println(isMatch);
    }
}
