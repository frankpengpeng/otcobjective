package com.frank.practice.tree;

import java.util.List;

public class BinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public BinaryTree(int[] arr) {
        this.root = buildTree(arr, 0);
    }

    public Node buildTree(int[] arr, int index){
        if (arr.length == 0 || index >= arr.length){
            return null;
        }
        Node root = new Node(arr[index]);
        root.setLeft(buildTree(arr, 2*index +1));
        root.setRight(buildTree(arr, 2*index+2));
        return root;
    }


    public void leftSequence(Node root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.getValue());
        leftSequence(root.getLeft(), list);
        leftSequence(root.getRight(), list);
    }

    public void midSquence(Node root, List<Integer> list){
        if(root == null){
            return;
        }
        midSquence(root.getLeft(), list);
        list.add(root.getValue());
        midSquence(root.getRight(), list);
    }

    public void rightSquence(Node root, List<Integer> list){
        if(root == null){
            return;
        }
        rightSquence(root.getLeft(), list);
        rightSquence(root.getRight(), list);
        list.add(root.getValue());
    }

    public void order(Node root){
        if(root == null){
            return;
        }
        if(root.getLeft() != null){
            Node left = root.getLeft();
            if(left.getValue()>root.getValue()){
                root.setLeft(left.getLeft());
                root.setRight(left.getRight());
                left.setLeft(root);
            }
            order(root);
        }
        if(root.getRight() != null){
            Node right = root.getRight();
            if(right.getValue() > root.getValue()){
                root.setRight(right.getRight());
                root.setLeft(right.getLeft());
                right.setRight(right);
            }
            order(root);
        }
    }
}
