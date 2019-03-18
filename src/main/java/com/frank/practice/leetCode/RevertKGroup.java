package com.frank.practice.leetCode;

import com.frank.practice.dataModel.ListNode;

import java.util.LinkedList;
import java.util.List;

public class RevertKGroup{
    public static void main(String[] args) {
        List<ListNode> list = new LinkedList<>();

        ListNode node6 = new ListNode(6, null );
        ListNode node5 = new ListNode(5, node6 );
        ListNode node4 = new ListNode(4, node5 );
        ListNode node3 = new ListNode(3, node4 );
        ListNode node2 = new ListNode(2, node3 );
        ListNode node1 = new ListNode(1, node2 );

        RevertKGroup demo = new RevertKGroup();
        ListNode head = demo.reverKNodes(node1,2);
        while (head != null) {
            System.out.println(head.getValue());
            head = head.next;
        }
    }

    private ListNode revertGroup(ListNode head, int k){
        ListNode pre = null;
        while (head != null) {
            pre = revertList(head,k);
            head = pre;
        }
        return pre;
    }


    private ListNode revertList(ListNode node, int k){
        int n = k;
        ListNode pre = null;
        ListNode temp = null;
        while (node != null && n >0){
            temp = node.next;
            node.next = pre;
            pre = node;
            node =temp;
            n--;
        }
        pre.next = temp;
        return temp;
    }

    private ListNode revert2Nodes(ListNode head){
        if(head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        head.next = head.next.next;
        node.next = head;
        node.next.next = revert2Nodes(node.next.next);

        return node;
    }

    private ListNode reverKNodes(ListNode head, int k) {
        ListNode last = head;
        int n = 0;
        while (n<k){
            if(last == null){
                return head;
            }
            last = last.next;
            n++;
        }
        ListNode dummy = head;
        ListNode a = head.next;
        for(int i=0;i<k-1;i++){
            ListNode b = a.next;
            a.next = head;
            head = a;
            a = b;
        }
        dummy.next = reverKNodes(last,k);
        return head;
    }


}
