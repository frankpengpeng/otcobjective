package com.frank.practice.leetCode;

import java.util.*;

public class GroupStrList {
    public static void main(String[] args) {
        String[] strList = new String[]{"ate","eat","tea","lok","kol","kpo"};
        List<List<String>>  res = new ArrayList<>();
        GroupStrList demo = new GroupStrList();
        demo.groupStings(strList,res);
        for(List sList:res){
            System.out.println(sList);
        }
        
    }

    private void groupStings(String[] strList, List<List<String>> res) {
        if(strList == null || strList.length ==0){
            return;
        }
        Map<String, List<String>> map = new HashMap<>();
        for(int i= 0;i< strList.length;i++){
            char[] c = strList[i].toCharArray();
            Arrays.sort(c);
            map.computeIfAbsent(String.valueOf(c), s->new ArrayList<>()).add(strList[i]);
        }
        for(String key:map.keySet()){
            res.add(map.get(key));
        }
    }
}
