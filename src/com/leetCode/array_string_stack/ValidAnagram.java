package com.leetCode.array_string_stack;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    static boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc, tc);
    }
}
