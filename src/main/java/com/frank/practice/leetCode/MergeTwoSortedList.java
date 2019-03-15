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

    private ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if(l1.value <= l2.value){
                dummy.next = new ListNode(l1.value);
                l1 = l1.next;
            } else {
                dummy.next = new ListNode(l2.value);
                l2= l2.next;
            }
            dummy = dummy.next;
        }
        if (l1 != null){
            dummy.next = l1;
        }
        if (l2 != null) {
            dummy.next = l2;
        }
        return head.next;
    }

    private ListNode mergeKList(ListNode[] lists) {
        int left = 0;
        int right = lists.length -1;
        return mergeKLinkedList(lists, left, right);
    }

    private ListNode mergeKLinkedList(ListNode[] lists, int left, int right) {
        if(left == right){
            return lists[left];
        }
        int mid = (left + right)/2;
        ListNode leftNode = mergeKLinkedList(lists, left, mid);
        ListNode rightNode = mergeKLinkedList(lists, mid+1, right);
        ListNode dummmy = new ListNode(0);
        ListNode node = dummmy;
        while (leftNode != null && rightNode != null){
            if(leftNode.value <= rightNode.value){
                dummmy.next = new ListNode(leftNode.value);
                leftNode = leftNode.next;
            } else {
                dummmy.next = new ListNode(rightNode.value);
                rightNode = rightNode.next;
            }
        }
        if(leftNode != null){
            dummmy.next = leftNode;
        }
        if(rightNode != null){
            dummmy.next = rightNode;
        }
        return node.next;
    }
}
