package com.dynamicProgramming.strings;

import java.util.Arrays;

public class DP34WildcardMatching {
    public static void main(String[] args) {
        String p = "ab*";
        String s = "ab";
        System.out.println(wildcardMatching(p, s));
    }

    /**
     * Function from LC
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatchRecMemo(String s, String p) {
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n][m];
        for (int[] row :
                dp) {
            Arrays.fill(row, -1);
        }

        return solveRecMemo(n - 1, m - 1, s, p, dp) == 1;
    }

    private static int solveRecMemo(int i, int j, String s, String p, int[][] dp) {

        // base cases
        // If both String and Pattern are exhausted
        if (i < 0 && j < 0) {
            return 1;
        }
        // If pattern is exhausted
        if (i >= 0 && j < 0) {
            return 0;
        }
        // if only pattern is left
        if (i < 0 && j >= 0) {
            return isAllStar(p, j);
        }

        // memoization step
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Core logic
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j] = solveRecMemo(i - 1, j - 1, s, p, dp);
        } else {
            // here we have two possibilities
            if (p.charAt(j) == '*') {
                // Two possibilities when encountering '*':
                // 1. '*' matches one or more characters in text given
                // 2. '*' matches zero characters in text given
                return dp[i][j] = (solveRecMemo(i, j - 1, s, p, dp) == 1 || solveRecMemo(i - 1, j, s, p, dp) == 1) ? 1 : 0;
            } else {
                return 0;
            }
        }

    }

    private static int isAllStar(String p, int j) {
        for (int index = j; index >= 0; index--) {
            if (p.charAt(index) != '*') {
                return 0;
            }
        }
        return 1;
    }

    /**
     * Function from coding ninja
     *
     * @param pattern
     * @param text
     * @return
     */
    public static boolean wildcardMatching(String pattern, String text) {
        // Write your code here.
        int n = text.length();
        int m = pattern.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // base case
        dp[0][0] = true;

        // when pattern is exhausted
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }

        // when text is exhausted but pattern is still left
        for (int j = 1; j < m + 1; j++) {
            dp[0][j] = isAllStarTable(pattern, j);
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else {

                    if (pattern.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }

        return dp[n][m];
    }

    private static boolean isAllStarTable(String pattern, int j) {
        for (int index = 1; index <= j; index++) {
            if (pattern.charAt(index - 1) != '*') {
                return false;
            }
        }
        return true;
    }
}
