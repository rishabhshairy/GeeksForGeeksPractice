package com.leetCode.DP.easy;

/**
 * LC 1668
 */
public class MaxRepeatingSubstring {
    public static void main(String[] args) {
        String s = "ababc";
        String word = "ab";
        maxRepeating(s, word);
    }

    public static int maxRepeating(String sequence, String word) {
        int count = 0;

        String add = word;
        while (sequence.contains(add)) {
            count++;
            add += word;
        }
        System.out.println(count);
        return count;
    }

}
