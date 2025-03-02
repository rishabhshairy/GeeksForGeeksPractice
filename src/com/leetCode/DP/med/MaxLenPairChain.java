package com.leetCode.DP.med;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLenPairChain {
    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {7, 8}, {4, 5}};
        MaxLenPairChain obj = new MaxLenPairChain();
        obj.findLongestChain(pairs);
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int n = pairs.length;
        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, -1, pairs, dp);
    }

    private int solve(int index, int prevIndex, int[][] pairs, int[][] dp) {

        if (index == pairs.length) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        int notPick = solve(index + 1, prevIndex, pairs, dp);

        int pick = (int) -1e9;
        if (prevIndex == -1 || pairs[prevIndex][1] < pairs[index][0]) {
            pick = 1 + solve(index + 1, index, pairs, dp);
        }
        return dp[index][prevIndex + 1] = Math.max(pick, notPick);
    }
}
