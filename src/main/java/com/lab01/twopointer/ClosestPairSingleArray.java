package com.lab01.twopointer;

/**
 * Input - Given an array a and a number n,
 * Task - find the pair such that absolute value of (a[p1] + a[p2] – n) is minimum.
 */
public class ClosestPairSingleArray {
    public static void main(String[] args) {
        int[] array = {10, 20, 35, 50, 75, 80};
        closestPair(array, 1);
    }

    private static void closestPair(int[] array, int rsum) {
        //optimal
        int p1 = 0, minp1 = 0;
        int p2 = array.length - 1, minp2 = array.length - 1;
        int min = Math.abs(array[p2] + array[p1] - rsum);
        while (p1 < p2){
            int csum = array[p1] + array[p2];
            if(min > Math.abs(csum - rsum)){
                min = Math.abs(csum - rsum);
                minp1 = p1; minp2 = p2;
            }
            if(csum == rsum) {
                System.out.printf("Found Pair %s %s", array[p1], array[p2]);
                return;
            }
            else if (csum > rsum) {
                p2 -- ;
            }
            else {
                p1 ++ ;
            }

            System.out.printf("csum %s min %s", csum, min);
            System.out.println("");
        }
        System.out.printf("Closest Pair %s %s", array[minp1], array[minp2]);
    }

}
