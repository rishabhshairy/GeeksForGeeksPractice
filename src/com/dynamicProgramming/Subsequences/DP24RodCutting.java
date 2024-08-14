package com.dynamicProgramming.Subsequences;

import java.util.Arrays;

public class DP24RodCutting {
    public static void main(String[] args) {

    }

    /**
     * Writing Recursive and Memoized Code
     *
     * @param price
     * @param n
     * @return
     */
    public static int cutRodMemoization(int[] price, int n) {
        // Write your code here.
        int len = price.length;
        int[][] dp = new int[len][n + 1];
        for (int[] rows :
                dp) {
            Arrays.fill(rows, -1);
        }

        return solveRecMemo(len - 1, price, n, dp);
    }

    private static int solveRecMemo(int index, int[] price, int n, int[][] dp) {
        if (index == 0) {
            return price[0] * n;
        }

        if (dp[index][n] != -1) {
            return dp[index][n];
        }

        int notTake = solveRecMemo(index - 1, price, n, dp);
        int take = (int) Math.pow(-10, 9);
        int rodLength = index + 1;
        if (rodLength <= n) {
            take = price[index] + solveRecMemo(index, price, n - rodLength, dp); // infinite supply , stay at same index
        }
        return dp[index][n] = Math.max(take, notTake);
    }

    /**
     * Tabulation
     *
     * @param price
     * @param n
     * @return
     */
    public static int cutRodTabulation(int[] price, int n) {
        // Write your code here.
        int[][] dp = new int[n][n + 1];

        // base case
        for (int i = 0; i <= n; i++) {
            dp[0][i] = price[0] * i;
        }

        // form loops
        for (int index = 1; index < price.length; index++) {
            for (int rod = 0; rod <= n; rod++) {
                int notTake = dp[index - 1][rod];
                int take = (int) Math.pow(-10, 9);
                int rodLength = index + 1;
                if (rodLength <= rod) {
                    take = price[index] + dp[index][rod - rodLength];
                }

                dp[index][rod] = Math.max(take, notTake);
            }
        }

        return dp[price.length - 1][n];
    }
}
