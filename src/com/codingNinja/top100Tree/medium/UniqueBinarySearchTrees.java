package com.codingNinja.top100Tree.medium;

/**
 * You are given an integer ‘N’, your task is to return the number of structurally unique
 * BST's (binary search trees) which have exactly 'N' nodes of unique values from 1 to 'N'.
 * <p>
 * For example:
 * <p>
 * Given  ‘N’ = 2, The total number of BST’s is 2
 */
public class UniqueBinarySearchTrees {
    public static long numTrees(int n) {
        // Write your code here.
        long[] dp = new long[n + 2];

        if (n <= 1) {
            return 1;
        }

        dp[0] = 1;
        dp[1] = 1;

        long res = 0;
        for (int i = 2; i <= n; i++) {
            dp[i]=0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
