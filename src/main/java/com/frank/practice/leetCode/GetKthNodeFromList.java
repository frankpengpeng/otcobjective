package com.frank.practice.leetCode;

import com.frank.practice.dataModel.ListNode;

import java.util.LinkedList;
import java.util.List;

public class GetKthNodeFromList {
    public static void main(String[] args) {
        List<ListNode> list = new LinkedList<>();
        ListNode node5 = new ListNode(5, null );
        ListNode node4 = new ListNode(4, node5 );
        ListNode node3 = new ListNode(3, node4 );
        ListNode node2 = new ListNode(2, node3 );
        ListNode node1 = new ListNode(1, node2 );
        GetKthNodeFromList demo = new GetKthNodeFromList();

        ListNode kNode = demo.getKthMode(node1, 2);
        System.out.println(kNode.value);
    }

    private ListNode getKthMode(ListNode node, int k) {
        ListNode slow = node;
        ListNode fast = node;
        int n = 0;
        while (fast!=null){
            if(n < k){
                n++;
            } else {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return slow;
    }
}
