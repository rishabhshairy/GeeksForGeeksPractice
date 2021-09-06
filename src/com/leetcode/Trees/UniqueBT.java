package com.leetcode.Trees;

public class UniqueBT {
    public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;

            for (int i = 1; i < n + 1; i++) {
                if (i <= 2) {
                    dp[i] = i;
                    continue;
                }
                for (int j = 1; j < i; j++) {
                    dp[i] += (dp[i] * dp[i - j - 1]);
                }
            }
            return dp[n];
    }
}
