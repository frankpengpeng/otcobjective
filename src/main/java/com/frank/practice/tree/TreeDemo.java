package com.frank.practice.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{9,10,2,3,5,8,14,13,20,6};
        Node root = new Node(null, null, arr[0]);

        for(int i:arr){
            root.addChild(i);
        }
        BinaryTree tree = new BinaryTree(root);
        List<Integer> list = new ArrayList<>();
        tree.leftSequence(tree.getRoot(), list);
        for(int i:list){
            System.out.print(i+",");
        }
    }
}
