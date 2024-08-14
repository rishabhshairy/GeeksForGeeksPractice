package com.dynamicProgramming.strings;

import java.util.Arrays;

public class DP25LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(lcsRecMemo("adebc", "dcadb"));
    }

    /**
     * All Approaches
     * 1. Recursive
     * 2. Memoization
     * 3. Tabulation
     */
    public static int lcsRecMemo(String s, String t) {
        //Your code goes here
        int n1 = s.length();
        int n2 = t.length();

        int[][] dp = new int[n1][n2];
        for (int[] row :
                dp) {
            Arrays.fill(row, -1);
        }

        return solve(n1 - 1, n2 - 1, s, t, dp);
    }

    private static int solve(int index1, int index2, String s, String t, int[][] dp) {
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        // match case
        if (s.charAt(index1) == t.charAt(index2)) {
            return dp[index1][index2] = 1 + solve(index1 - 1, index2 - 1, s, t, dp);
        }
        // non Match case
        // move either index for 2 way possibilities
        return dp[index1][index2] = Math.max(solve(index1 - 1, index2, s, t, dp),
                solve(index1, index2 - 1, s, t, dp));
    }

    /**
     * Tabulation Approach
     * Here we will use concept of shifting of indexes
     *
     * @param s
     * @param t
     * @return
     */
    public static int lcs(String s, String t) {
        //Your code goes here
        int n1 = s.length();
        int n2 = t.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int index1 = 1; index1 < n1 + 1; index1++) {
            for (int index2 = 1; index2 < n2 + 1; index2++) {
                if (s.charAt(index1 - 1) == t.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                } else {
                    dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
