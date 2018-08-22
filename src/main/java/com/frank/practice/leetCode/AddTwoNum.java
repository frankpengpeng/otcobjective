package com.frank.practice.leetCode;

public class AddTwoNum {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode la = new ListNode(2);
        ListNode la1 = new ListNode(4);
        ListNode la2 = new ListNode(3);
        ListNode lb = new ListNode(5);
        ListNode lb1 = new ListNode(6);
        ListNode lb2 = new ListNode(4);
        la.next = la1;
        la1.next = la2;
        lb.next = lb1;
        lb1.next = lb2;
        AddTwoNum addTwoNum = new AddTwoNum();
        ListNode result = addTwoNum.add(la,lb);
        //ListNode ret = addTwoNum.revert(result);
        while (result != null){
            System.out.println(result.val);
            result=result.next;
        }
    }

     ListNode add(ListNode la, ListNode lb){

        ListNode p = la;
        ListNode q = lb;
        ListNode dummyHead = new ListNode(0);
        ListNode curNode = dummyHead;
        int carry = 0;
        while (p != null || q != null){
            int x = p != null? p.val:0;
            int y =q != null? q.val:0;
            int digit = (x+y+carry)%10;
            carry = (x+y+carry)/10;
            curNode.next = new ListNode(digit);
            curNode = curNode.next;
            p = p != null?p.next:null;
            q = q != null?q.next:null;
        }
        if(carry>0){
            curNode.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    ListNode revert(ListNode node){
        if(node == null || node.next == null){
            return null;
        }else {
            ListNode newNode = revert(node.next);
            node.next.next = node;
            node.next = null;
            return newNode;
        }
    }
}
