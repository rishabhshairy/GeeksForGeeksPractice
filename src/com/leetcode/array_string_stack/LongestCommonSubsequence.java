package com.leetcode.array_string_stack;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "ace";
        System.out.println(longestCommonSubsequence(s1, s2));
    }

    private static int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] tdp = new int[n + 1][m + 1];

        for (int[] row :
                tdp) {
            Arrays.fill(row, 0);
        }

        // evluate LCS

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    tdp[i][j] = 1 + tdp[i - 1][j - 1];
                } else {
                    tdp[i][j] = Math.max(tdp[i - 1][j], tdp[i][j - 1]);
                }
            }
        }
        return tdp[n][m] == -1 ? 0 : tdp[n][m];
    }
}
