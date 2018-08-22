package com.frank.practice.tree;

public class Node {
    private Node left;
    private Node right;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addChild(int val){
        if(val == value){
            return;
        }
        if(val<value){
            if(left!=null){
                left.addChild(val);
            } else {
                left = new Node(null, null, val);
            }
        } else {
            if(right!=null){
                right.addChild(val);
            } else {
                right = new Node(null, null, val);
            }
        }
    }
}
