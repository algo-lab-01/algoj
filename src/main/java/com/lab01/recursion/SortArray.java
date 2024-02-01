package com.lab01.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * input - given a array
 * task - sort array using recursion
 * output - sorted array
 */
public class SortArray {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 3, 0, 5, 2));
        sort(arr);
        System.out.println(arr);
    }
    static void sort(List<Integer> a){
        if(a.size() == 1){
            return;
        }
        int index = a.size()-1;
        Integer temp = a.get(index);
        a.remove(temp);
        sort(a);
        insert(a, temp);
    }

    static void insert(List<Integer> a, Integer temp){
        if(a.isEmpty() || temp >= a.get(a.size()-1)){
            a.add(temp);
            return;
        }

        int index = a.size() - 1;
        Integer val = a.get(index);
        a.remove(val);
        insert(a, temp);
        a.add(val);
    }
}
