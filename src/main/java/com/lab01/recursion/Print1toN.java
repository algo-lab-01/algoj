package com.lab01.recursion;

/**
 * inout -  a number - N
 * task - print all numbers from 1 to N using recursion
 */
public class Print1toN {
    public static void main(String[] args) {
        int N = 5;
        print(N);
    }
    static void print(int N){
        if(N == 0)
            return;
        print(N-1);
        System.out.println(N);
    }
}
