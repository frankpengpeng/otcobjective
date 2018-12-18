package com.frank.practice.dataModel;

public class ListNode {
    public Integer value;
    public ListNode next;


    public ListNode(Integer value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public Integer getValue() {
        return value;

    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
