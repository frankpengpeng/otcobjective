package com.frank.practice.leetCode;

import java.util.Stack;

public class StackQueue {
    public static void main(String[] args) {
        Stack<String> in = new Stack<String>();
        Stack<String> out = new Stack<String>();
        Aqueue qu = new Aqueue(in,out);
        qu.push("a");
        System.out.println("the content of queue after insert a:" + qu.peek());
        qu.push("b");
        System.out.println("the content of queue after inserting b" + qu.peek());
        qu.push("c");
        System.out.println("the content of queue after inserting c" + qu.peek());
        qu.pop();
        System.out.println("the content of queue after removing c:" + qu.peek());

    }
    static class Aqueue {
        private Stack<String> inputStatck;
        private Stack<String> outputStack;
        Aqueue(Stack<String> in, Stack<String> out){
            inputStatck = in;
            outputStack = out;
        }
       String pop(){
           outputStack.addAll(inputStatck);
           inputStatck.clear();
           return outputStack.pop();
       }

       String peek(){
           outputStack.addAll(inputStatck);
           inputStatck.clear();
           return outputStack.peek();
       }

       void push(String s){
           inputStatck.push(s);
       }
    }
}
