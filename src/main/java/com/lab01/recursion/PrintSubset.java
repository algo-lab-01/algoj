package com.lab01.recursion;

import java.util.HashSet;
import java.util.Set;

/**
 * Print Subsets
 * input - ab
 * output - "", a, b, ab
 */
public class PrintSubset {
    public static void main(String[] args) {
        String s = "ab";
        Set<String> subsetList = new HashSet<>();
        char[] sArr = s.toCharArray();
        //brute force
        subsetList.add("");
        int iterate = 0;
        for (int i =0; i< sArr.length ; i++){
            subsetList.add(String.valueOf(sArr[i]));
            iterate ++;
            for (int j = i+1; j< sArr.length; j++){
                if( i != j) {
                    String o = sArr[i] + "" + sArr[j];
                    subsetList.add(o);
                }
                iterate ++;
            }
        }
        subsetList.add(s);
        System.out.println("iterations - "+iterate);
        //subsets(s, 0, subsetList);
        System.out.println(subsetList);
    }

    private static void subsets(String s, int index, Set<String> subsetList) {
        if(index > s.length()) //base condition
            return;
        subsetList.add(s.substring(0,index)); //Induction
        index ++;
        subsets(s, index, subsetList); //Hypothesis
    }
}
