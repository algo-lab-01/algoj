package com.lab01.recursion;

public class PrintNto1 {
    public static void main(String[] args) {
        int N = 10;

        print(N);
    }
    static void print(int N){
        if( N == 0)
            return;
        System.out.println(N);
        print(N-1);
    }
}
