package com.frank.practice.leetCode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses demo = new ValidParentheses();
        System.out.println(demo.isValid("()[]{}"));
    }
    private boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c: str.toCharArray()){
            if(c == '(') {
                stack.push(')');
            } else if(c == '[') {
                stack.push(']');
            } else if(c == '{') {
                stack.push('}');
            }  else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
