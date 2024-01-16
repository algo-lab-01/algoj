package com.lab01.ds;

import java.util.Arrays;

//sorting using heap
public class HeapMain {
    public static void main(String[] args) {
        int[] a = {10, 20, 11, 13, 7, 8};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}

class HeapSort {
    void sort(int[] a, int N){
        for(int i = (N - 1) / 2; i >= 0 ; i--){
            heapify(a, N, i);
        }
        for(int i = N-1; i > 0 ; i--){
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            heapify(a, i, 0);
        }
    }

    void heapify(int[] a, int N, int i){
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if(l < N && a[largest] < a[l]){
            largest = l ;
        }
        if(r < N && a[largest] < a[r]){
            largest = r ;
        }
        if(largest != i){
            int temp = a[largest];
            a[largest] = a[i];
            a[i] = temp;
            heapify(a, N, largest);
        }
    }
}