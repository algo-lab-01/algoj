package com.lab01.collections;

import java.util.*;;
public class TreeMapCustom {
    public static void main(String[] args) {
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("1", "value1");
        treeMap.put("2", "value2");
        treeMap.put("10", "value10");
        treeMap.put("11", "value11");
        // for(String key: treeMap.keySet()){
        //     System.out.println(key);
        // }

        long i = 5000000;
        System.out.println((int) i ^ i >>> 32);
    }
}
