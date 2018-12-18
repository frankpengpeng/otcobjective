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
        demo.revertGroup(node1, 2);
        System.out.println(node1.toString());
    }

    private void revertGroup(ListNode head, int k){
        ListNode pre = null;
        while (head != null) {
            pre = revert(head,pre,k);
            head = pre.next;
        }
    }
    private ListNode revert(ListNode head, ListNode pre, int k) {
            ListNode tmp = null;
            int in = k;
            while (head != null && in > 0) {
                tmp = head.getNext();
                head.setNext(pre);
                pre = head;
                head = tmp;
                in--;
            }
            return pre;
    }
}
