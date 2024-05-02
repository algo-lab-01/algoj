package com.lab01.collections;

import java.util.*;

public class FailFast {
    public static void main(String[] args) {
        List<Integer> listInt = List.of(1, 2, 3);
        List<Integer> secondList = new ArrayList<>();
        for(Integer num: listInt){
            num ++;
            secondList.add(num);
        }
        for(Integer num: secondList){
            System.out.println(num);
        }

        Map<String, String> map = Map.of("key1","value1", "key2","value2");
        /**
         * ConcurrentHashMap 
         */
        for(Map.Entry<String, String> entry: map.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
