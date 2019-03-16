package com.frank.practice.leetCode;

import com.frank.practice.dataModel.ListNode;

import java.util.LinkedList;
import java.util.List;

public class GetMidOFList {

    public static void main(String[] args) {
        GetMidOFList demo = new GetMidOFList();
        List<ListNode> list = new LinkedList<>();
        ListNode node5 = new ListNode(5, null );
        ListNode node4 = new ListNode(4, node5 );
        ListNode node3 = new ListNode(3, node4 );
        ListNode node2 = new ListNode(2, node3 );
        ListNode node1 = new ListNode(1, node2 );

        ListNode mid = demo.getMid(node1);
        System.out.println(mid.value);
    }

    private ListNode getMid(ListNode node) {

        ListNode slow = node;
        ListNode fast = node;
        while (slow!=null &&fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
