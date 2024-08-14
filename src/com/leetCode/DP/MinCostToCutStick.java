package com.leetCode.DP;

import java.util.Arrays;

public class MinCostToCutStick {
    public static void main(String[] args) {
        MinCostToCutStick obj = new MinCostToCutStick();
        System.out.println(obj.minCost(7, new int[]{5, 3, 1, 4}));
    }

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[][] dp = new int[cuts.length][cuts.length];
        for (int[] rows :
                dp) {
            Arrays.fill(rows, -1);
        }
        return solve(0, cuts.length - 1, 0, n, cuts, dp);
    }

    private int solve(int start, int end, int rodStart, int rodEnd, int[] cuts, int[][] dp) {
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int min = (int)1e9;
        for (int k = start; k <= end; k++) {
            int count = rodEnd - rodStart + solve(start, k - 1, rodStart, cuts[k], cuts, dp) +
                    solve(k + 1, end, cuts[k], rodEnd, cuts, dp);
            min = Math.min(min, count);
        }
        return dp[start][end] = min;
    }
}
