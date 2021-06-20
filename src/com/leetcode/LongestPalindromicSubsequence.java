package com.leetcode;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "bbbab";
    }

    static int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();

        int[][] tdp = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    tdp[i][j] = 0;
                } else if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    tdp[i][j] = 1 + tdp[i - 1][j - 1];
                } else {
                    tdp[i][j] = Math.max(tdp[i - 1][j], tdp[i][j - 1]);
                }
            }
        }

        return tdp[n][n];
    }
}
