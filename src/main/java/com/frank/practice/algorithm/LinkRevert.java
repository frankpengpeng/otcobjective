package com.frank.practice.algorithm;

import com.frank.practice.dataModel.TravelPath;

public class LinkRevert {
    private TravelPath buildLink(){
        TravelPath start = new TravelPath("shanghai");
        TravelPath suzhou = new TravelPath("suzhou");
        start.setNext(suzhou);
        TravelPath wuxi = new TravelPath("wuxi");
        suzhou.setNext(wuxi);
        TravelPath nanjing = new TravelPath("nanjing");
        wuxi.setNext(nanjing);
        TravelPath huaibei = new TravelPath("huaibie");
        nanjing.setNext(huaibei);
        return start;
    }

    public static void main(String[] args) {
        LinkRevert revertor = new LinkRevert();
        TravelPath loc = revertor.buildLink();
//        while (loc.getNext() != null){
//            System.out.println(loc.getLocation() + "->");
//            loc = loc.getNext();
//        }
//        System.out.println(loc.getLocation());
//        TravelPath start = loc;
//        TravelPath tmp;
        TravelPath reult = revertor.reset(loc);

        while (reult.getNext() != null){
            System.out.println(reult.getLocation() + "->");
            reult = reult.getNext();
        }
        System.out.println(reult.getLocation());
    }

    private TravelPath revert(TravelPath head){
        if(head == null || head.getNext() == null){
            return head;
        }
        TravelPath current = head;
        TravelPath newHead = null;
        TravelPath next = null;
        while (current !=null){
            next = current.next;
            current.next = newHead;
            newHead = current;
            current = next;
        }
        return newHead;
    }

    private TravelPath reset(TravelPath head){
        if(head == null || head.next == null){
            return head;
        } else {
            TravelPath newHead = reset(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }
    }
}
