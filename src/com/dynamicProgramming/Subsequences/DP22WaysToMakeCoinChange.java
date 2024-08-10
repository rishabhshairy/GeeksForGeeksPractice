package com.dynamicProgramming.Subsequences;

import java.util.Arrays;

public class DP22WaysToMakeCoinChange {

    /**
     * Recursive and Memoization Solution
     *
     * @param denominations
     * @param value
     * @return
     */
    public static long countWaysToMakeChangeRecursive(int[] denominations, int value) {
        //write your code here
        int n = denominations.length;
        long[][] dp = new long[n][value + 1];

        for (long[] row :
                dp) {
            Arrays.fill(row, -1);
        }

        return countWaysRecMemo(n - 1, denominations, value, dp);
    }

    private static long countWaysRecMemo(int index, int[] denominations, int value, long[][] dp) {

        // base case
        if (index == 0) {
            if (value % denominations[index] == 0) {
                return 1;
            }
            return 0;
        }

        if (dp[index][value] != -1) {
            return dp[index][value];
        }

        long notPick = countWaysRecMemo(index - 1, denominations, value, dp);
        long pick = 0;
        if (denominations[index] <= value) {
            pick = countWaysRecMemo(index, denominations, value - denominations[index], dp);

        }

        return dp[index][value] = notPick + pick;
    }

    /**
     * Tabulation
     *
     * @param denominations
     * @param value
     * @return
     */
    public static long countWaysToMakeChange(int denominations[], int value) {
        //write your code here
        int n = denominations.length;
        long[][] dp = new long[n + 1][value + 1];

        // base case
        for (int T = 0; T <= value; T++) {
            dp[0][T] = value % denominations[0] == 0 ? 1 : 0;
        }

        for (int index = 1; index < n; index++) {
            for (int val = 0; val <= value; val++) {
                long notPick = dp[index - 1][val];
                long pick = 0;
                if (denominations[index] <= val) {
                    pick = dp[index][val - denominations[index]];
                }
                dp[index][val] = notPick + pick;
            }
        }
        return dp[n - 1][value];
    }
}
