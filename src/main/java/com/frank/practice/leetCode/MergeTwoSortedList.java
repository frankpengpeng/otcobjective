package com.frank.practice.leetCode;

import com.frank.practice.dataModel.ListNode;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        MergeTwoSortedList demo = new MergeTwoSortedList();
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null){
            if(p1.value <= p2.value){
                dummy.next = new ListNode(p1.value);
                p1 = p1.next;
            } else {
                dummy.next = new ListNode(p2.getValue());
                p2 = p2.next;
            }
            dummy = dummy.next;
        }
        if(p1 != null){
            dummy.next = p1;
        }
        if(p2 != null){
            dummy.next = p2;
        }
        return head.next;
    }
}
