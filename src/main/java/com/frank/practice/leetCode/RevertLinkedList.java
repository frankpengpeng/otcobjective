package com.frank.practice.leetCode;

import com.frank.practice.dataModel.ListNode;

import java.util.LinkedList;
import java.util.List;

public class RevertLinkedList {
    public static void main(String[] args) {
        List<ListNode> list = new LinkedList<>();
        ListNode node5 = new ListNode(5, null );
        ListNode node4 = new ListNode(4, node5 );
        ListNode node3 = new ListNode(3, node4 );
        ListNode node2 = new ListNode(2, node3 );
        ListNode node1 = new ListNode(1, node2 );


        RevertLinkedList demo = new RevertLinkedList();
        ListNode head = demo.revert(node1);
        while (head !=null){
            System.out.print(head.getValue() + ";");
            head = head.getNext();
        }
    }
    private ListNode revert(ListNode head) {
        ListNode pre = null;
        ListNode tmp = null;
        while (head != null) {
            tmp = head.getNext();
            head.setNext(pre);
            pre = head;
            head = tmp;
        }
        return pre;
    }
}
