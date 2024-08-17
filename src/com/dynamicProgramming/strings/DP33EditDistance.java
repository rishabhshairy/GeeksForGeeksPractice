package com.dynamicProgramming.strings;

import java.util.Arrays;

/**
 * LC Hard
 */
public class DP33EditDistance {
    public static void main(String[] args) {
        String a = "horse";
        String b = "ros";
        System.out.println(editDistance(a, b));
    }

    /**
     * Recursive and Memoization Approach
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int editDistanceRecursiveMemoization(String str1, String str2) {
        //Your code goes here
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n][m];

        for (int[] row :
                dp) {
            Arrays.fill(row, -1);
        }

        return solveRecMemo(n - 1, m - 1, str1, str2, dp);
    }

    private static int solveRecMemo(int index1, int index2, String str1, String str2, int[][] dp) {

        // base case
        if (index1 < 0) {
            return index2 + 1; // no of ops to insert left over str2
        }

        if (index2 < 0) {
            return index1 + 1; // no of ops to delete str1
        }

        // memoization
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        // match case
        if (str1.charAt(index1) == str2.charAt(index2)) {
            return dp[index1][index2] = solveRecMemo(index1 - 1, index2 - 1, str1, str2, dp);
        } else {
            // 3 ops in non match case
            int insert = 1 + solveRecMemo(index1, index2 - 1, str1, str2, dp);
            int delete = 1 + solveRecMemo(index1 - 1, index2, str1, str2, dp);
            int replace = 1 + solveRecMemo(index1 - 1, index2 - 1, str1, str2, dp);

            return dp[index1][index2] = Math.min(insert, Math.min(delete, replace));

        }
    }

    /**
     * Tabulation
     *
     * @param str1
     * @param str2
     * @return Operations
     */
    public static int editDistance(String str1, String str2) {

        // step 1 init DP table , since we are doing string ops use index shifting
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];

        // base case

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 3 ops
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];

                    dp[i][j] = Math.min(insert, Math.min(delete, replace));

                }
            }
        }

        return dp[n][m];
    }
}
