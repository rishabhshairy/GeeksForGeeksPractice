package com.dynamicProgramming.Subsequences;

import java.util.Arrays;

public class DP19ZeroOneKnapsack {
    public static void main(String[] args) {

    }

    static int knapsackRecMemo(int[] weight, int[] value, int n, int maxWeight) {

        int[][] dp = new int[n][maxWeight + 1];
        for (int[] row :
                dp) {
            Arrays.fill(row, -1);
        }

        return solveRecMemo(n - 1, weight, value, maxWeight, dp);

    }

    /**
     * Recursion and Memoization Code
     * TC --> O (NxW)
     * SC --> O (NxW) + O(N) [StackSpace]
     *
     * @param index
     * @param weight
     * @param value
     * @param maxWeight
     * @param dp
     * @return
     */
    private static int solveRecMemo(int index, int[] weight, int[] value, int maxWeight, int[][] dp) {

        if (index == 0) {
            if (weight[index] <= maxWeight) {
                return value[index];
            }
            return 0;
        }

        if (dp[index][maxWeight] != -1) {
            return dp[index][maxWeight];
        }

        int notPick = 0 + solveRecMemo(index - 1, weight, value, maxWeight, dp);
        int pick = (int) Math.pow(-10, 9);
        if (weight[index] <= maxWeight) {
            pick = value[index] + solveRecMemo(index - 1, weight, value, maxWeight - weight[index], dp);
        }

        return dp[index][maxWeight] = Math.max(notPick, pick);
    }

    /**
     * Tabulation Approach
     *
     * @param weight
     * @param value
     * @param n
     * @param maxWeight
     * @return
     */
    static int knapsackTabulation(int[] weight, int[] value, int n, int maxWeight) {

        // Step 1 --> Declare DP of size used in memo
        int[][] dp = new int[n][maxWeight + 1];

        // Step 2 --> base case
        for (int i = weight[0]; i <= maxWeight; i++) {
            dp[0][i] = value[0];
        }

        // step 3 --> write nested loops of changing params
        for (int index = 1; index < n; index++) {
            for (int currWeight = 0; currWeight <= maxWeight; currWeight++) {
                int notPick = dp[index - 1][currWeight];
                int pick = (int) Math.pow(-10, 9);
                if (weight[index] <= currWeight) {
                    pick = value[index] + dp[index - 1][currWeight - weight[index]];
                }

                dp[index][currWeight] = Math.max(notPick, pick);
            }
        }

        return dp[n - 1][maxWeight];
    }

    /**
     * @param weight
     * @param value
     * @param n
     * @param maxWeight
     * @return
     */
    static int knapsackSpaceOptimised(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight + 1];
        for (int i = weight[0]; i <= maxWeight; i++) {
            prev[i] = value[0];
        }

        for (int index = 1; index < n; index++) {
            // we can comment curr row and make it more optimised
            // in that we need to start from Right to Left
            //
            int[] curr = new int[maxWeight + 1];
            for (int currWeight = 0; currWeight <= maxWeight; currWeight++) {
                int notPick = prev[currWeight];
                int pick = (int) Math.pow(-10, 9);
                if (weight[index] <= currWeight) {
                    pick = value[index] + prev[currWeight - weight[index]];
                }

                curr[currWeight] = Math.max(notPick, pick);
            }
            prev = curr;
        }

        return prev[maxWeight];
    }
}
