package com.dynamicProgramming.Subsequences;

import java.util.Arrays;

public class DP23UnboundedKnapsack {
    public static void main(String[] args) {

    }

    /**
     * Recursive and Memoization solution
     *
     * @param n
     * @param w
     * @param profit
     * @param weight
     * @return
     */
    public static int unboundedKnapsackRecursive(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[][] dp = new int[n][w + 1];
        for (int[] row :
                dp) {
            Arrays.fill(row, -1);
        }

        return solveRecMemo(n - 1, w, profit, weight, dp);
    }

    private static int solveRecMemo(int index, int w, int[] profit, int[] weight, int[][] dp) {

        // base case
        if (index == 0) {
            if (weight[0] <= w) {
                return (w / weight[0]) * profit[0];
            }
            return 0;
        }

        if (dp[index][w] != -1) {
            return dp[index][w];
        }

        int notPick = 0 + solveRecMemo(index - 1, w, profit, weight, dp);
        int pick = (int) Math.pow(-10, 9);
        if (weight[index] <= w) {
            pick = profit[index] + solveRecMemo(index, w - weight[index], profit, weight, dp);
        }

        return dp[index][w] = Math.max(notPick, pick);
    }

    /**
     * tabulation
     *
     * @param n
     * @param w
     * @param profit
     * @param weight
     * @return
     */
    public static int unboundedKnapsackTabulation(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w + 1];

        // base case
        for (int i = 0; i <= w; i++) {
            dp[0][i] = (i / weight[0]) * profit[0];
        }

        // form nested loops
        for (int index = 1; index < n; index++) {
            for (int currWeight = 0; currWeight <= w; currWeight++) {
                int notPick = dp[index - 1][currWeight];
                int pick = (int) Math.pow(-10, 9);
                if (weight[index] <= currWeight) {
                    pick = profit[index] + dp[index][currWeight - weight[index]];
                }
                dp[index][currWeight] = Math.max(notPick, pick);
            }
        }
        return dp[n - 1][w];

        /**
         * Space Optimised
            int[] prev = new int[w + 1];

            // base case
            for (int currWeight = 0; currWeight <= w; currWeight++) {
                prev[currWeight] = (currWeight / weight[0]) * profit[0];
            }

            // form nested loops
            for (int index = 1; index < n; index++) {
                int[] curr = new int[w + 1];
                for (int currWeight = 0; currWeight <= w; currWeight++) {
                    int notPick = prev[currWeight];
                    int pick = (int) Math.pow(-10, 9);
                    if (weight[index] <= currWeight) {
                        pick = profit[index] + prev[currWeight - weight[index]];
                    }
                    prev[currWeight] = Math.max(notPick, pick);
                }
            }
            return prev[w];
         **/
    }
}
