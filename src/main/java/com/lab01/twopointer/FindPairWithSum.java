package com.lab01.twopointer;

/**
 * Given a sorted array A (sorted in ascending order),
 * having N integers, find if there exists any pair of elements (A[i], A[j]) such that their sum is equal to X.
 */
public class FindPairWithSum {
    public static void main(String[] args) {
        int[] array = {10, 20, 35, 50, 75, 80};
        findPair(array, 120);
    }

    private static void findPair(int[] array, int rsum) {
        //optimal
        int p1 = 0; int p2 = array.length - 1;
        while (p1 < p2){
            int csum = array[p1] + array[p2];
            if(csum == rsum) {
                System.out.printf("Found Pair %s %s", array[p1], array[p2]);
                return;
            }
            else if (csum > rsum) {
                p2 -- ;
            }
            else
                p1 ++ ;
        }
        System.out.println("No pair found");
    }
}
