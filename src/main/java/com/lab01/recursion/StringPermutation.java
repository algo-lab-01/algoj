package com.lab01.recursion;

public class StringPermutation {
    public static void main(String[] args) {
        String s = "hem";
        permutation(s, "");
    }

    static void permutation(String s, String prefix) {
        if (s.isEmpty()) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String rem = s.substring(0, i) + s.substring(i + 1);
            permutation(rem, prefix + s.charAt(i));
        }

    }
}
