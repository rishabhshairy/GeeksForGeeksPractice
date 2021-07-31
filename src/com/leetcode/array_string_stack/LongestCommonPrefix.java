package com.leetcode.array_string_stack;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] s = {"dog", "car", "racecar"};
        System.out.print(longestCommonPrefix(s));
    }

    static String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            Arrays.sort(strs);
            String smallest = strs[0];
            String largest = strs[strs.length - 1];
            int i = 0;
            for (i = 0; i < smallest.length(); ) {
                if (smallest.charAt(i) == largest.charAt(i)) {
                    i++;
                } else {
                    break;
                }
            }

            return i == 0 ? "" : smallest.substring(0, i);
    }
}
