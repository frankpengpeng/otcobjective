package com.frank.practice.leetCode;

import com.frank.practice.dataModel.ListNode;

import java.util.LinkedList;
import java.util.List;

public class SwapTwo {
    public static void main(String[] args) {
        List<ListNode> list = new LinkedList<>();
        ListNode node5 = new ListNode(5, null );
        ListNode node4 = new ListNode(4, node5 );
        ListNode node3 = new ListNode(3, node4 );
        ListNode node2 = new ListNode(2, node3 );
        ListNode node1 = new ListNode(1, node2 );
        SwapTwo demo = new SwapTwo();
        ListNode head = demo.swap(node1);
        while (head !=null){
            System.out.print(head.getValue() + ";");
            head = head.getNext();
        }
    }

    private ListNode swap(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode nextLoopNode = next.next;
        next.next = head;
        ListNode nextHead = swap(nextLoopNode);
        head.next = nextHead;
        return next;
    }
}
