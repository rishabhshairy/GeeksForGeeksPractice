package com.leetCode.DP.med;

import java.util.Arrays;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int start = 0;
        int end = piles.length - 1;
        int n = piles.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // stating 3rd variable for game turn
        return solve(start, end, true, piles, dp) > 0;
    }

    private int solve(int start, int end, boolean turn, int[] piles, int[][] dp) {
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        // alice turn
        if (turn) {
            int pickFirst = solve(start + 1, end, false, piles, dp) + piles[start];
            int pictLast = solve(start, end - 1, false, piles, dp) + piles[end];
            return dp[start][end] = Math.max(pickFirst, pictLast);
        }

        // bob turn
        int pickFirst = solve(start + 1, end, true, piles, dp) - piles[start];
        int pictLast = solve(start, end - 1, true, piles, dp) - piles[end];
        return dp[start][end] = Math.max(pickFirst, pictLast);
    }
}
