package com.leetCode.DP.hard;

import java.util.Arrays;

public class BestSightSeeingPair {

    public static void main(String[] args) {
        int[] values = {8, 1, 5, 2, 6};
        BestSightSeeingPair obj = new BestSightSeeingPair();
        int pair = obj.maxScoreSightseeingPair(values);
        System.out.println(pair);

    }

    /**
     * Tabulation
     *
     * @param values
     * @return
     */
    private int maxScoreSightseeingPair(int[] values) {
        int[] dp = new int[values.length];
        dp[0] = values[0];

        int maxi = Integer.MIN_VALUE;
        for (int i = 1; i < values.length; i++) {
            maxi = Math.max(maxi, dp[i - 1] + values[i] - i);
            dp[i] = Math.max(dp[i - 1], values[i] + i);
        }
        return maxi;
    }


    /**
     * Tabulation
     */


    /**
     * Recursive approach
     * total = arr[i] + i + arr[j] - j
     *
     * @param values
     * @return
     */
    public int maxScoreSightseeingPairRecursive(int[] values) {
        int[][] dp = new int[values.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, values, dp);
    }

    /**
     * #    f(i+1,k+1) is added to pick because,
     * #    total = arr[i] + i + arr[j] - j
     * #    values[ind] + ind = arr[i] + i
     * #    f(ind+1,c+1) = arr[j] - j
     */
    private int solve(int i, int j, int[] values, int[][] dp) {
        if (j == 2) {
            return 0;
        }

        if (i >= values.length) {
            return -(int) 1e9;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int pick = 0;
        if (j == 0) {
            pick = solve(i + 1, j + 1, values, dp) + values[i] + i;
        } else {
            pick = solve(i + 1, j + 1, values, dp) + values[i] - i;
        }
        int notPick = solve(i + 1, j, values, dp);
        return dp[i][j] = Math.max(pick, notPick);
    }

    /**
     * Brute Force
     *
     * @param values
     * @return
     */
    public int maxScoreSightseeingPairBruteForce(int[] values) {
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                int pair = (values[i] + i) + (values[j] - j);
                maxi = Math.max(maxi, pair);
            }
        }
        return maxi;
    }
}
