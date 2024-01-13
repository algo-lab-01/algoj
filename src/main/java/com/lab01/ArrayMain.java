package com.lab01;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * operation on arrays
 * initialize
 * random access
 * add
 * search
 *
 */
public class ArrayMain {
    public static void main(String[] args) {
        //1.1 Print array
        int[] a = new int[0];
        long startTime = System.currentTimeMillis();
        System.out.printf("Empty array print using Arrays class"+ Arrays.toString(a));
        System.out.println(" -- Execution time in ms"+(System.currentTimeMillis()-startTime));

        //1.2 Print array custom
        startTime = System.currentTimeMillis();
        System.out.printf("Empty array print using Custom class"+ ArrayMain.arrayToStringV1(a));
        System.out.println(" -- Execution time in ms"+(System.currentTimeMillis()-startTime));

        //2.1 Random number pick from array
        int[] b = {1, 2, 3, 4, 5, 6};
        startTime = System.currentTimeMillis();
        System.out.printf("Random number pick #1 from array {1, 2, 3, 4, 5, 6} => "+randomPick(b));
        System.out.println(" -- Execution time in ms"+(System.currentTimeMillis()-startTime));

        //2.2 Random number pick from array
        startTime = System.currentTimeMillis();
        System.out.printf("Random number pick #2 from array {1, 2, 3, 4, 5, 6} => "+randomPick(b));
        System.out.println(" -- Execution time in ms"+(System.currentTimeMillis()-startTime));

    }

    private static int randomPick(int[] c) {
        int index = ThreadLocalRandom.current().nextInt(0, c.length);
        return c[index];
    }

    public static String arrayToStringV1(int[] a){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int j : a) {
            stringBuilder.append(j);
            stringBuilder.append(" ,");
        }
        int lastIndex = stringBuilder.lastIndexOf(" ,");
        stringBuilder.append("]");
        return lastIndex > -1 ? stringBuilder.replace(lastIndex, lastIndex+2, "").toString() : stringBuilder.toString();
    }

}
