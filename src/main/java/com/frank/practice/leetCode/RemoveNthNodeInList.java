package com.frank.practice.leetCode;

import com.frank.practice.dataModel.ListNode;

import java.util.LinkedList;
import java.util.List;

public class RemoveNthNodeInList {
    public static void main(String[] args) {
        List<ListNode> list = new LinkedList<>();
        ListNode node5 = new ListNode(5, null );
        ListNode node4 = new ListNode(4, node5 );
        ListNode node3 = new ListNode(3, node4 );
        ListNode node2 = new ListNode(2, node3 );
        ListNode node1 = new ListNode(1, node2 );
        RemoveNthNodeInList demo = new RemoveNthNodeInList();
        ListNode head = demo.removeNthNode(node1, 1);
        while (head !=null){
            System.out.print(head.getValue() + ";");
            head = head.getNext();
        }
    }

    private ListNode removeNthNode(ListNode head, int n){
        ListNode list = head;
        ListNode l1 = head;
        ListNode l2 = head;
        int index = 0;
        while (list != null){
            if(index -n > 0) l1 =l1.next;
            if(index + 2 -n >0) l2 =l2.next;
            index ++;
            list = list.next;
        }
        if (index == n){
            return head.next;
        }
        l1.next = l2;
        return head;
    }
}
