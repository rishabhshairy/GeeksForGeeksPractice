package com.dynamicProgramming.Subsequences;

import java.util.Arrays;

public class DP20MinCoins {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int target = 7;
        System.out.println(minimumCoins(arr, target));
    }

    public static int minimumCoins(int num[], int target) {
        // Write your code here..
        int n = num.length;
        int[][] dp = new int[n][target + 1];
        for (int[] row :
                dp) {
            Arrays.fill(row, -1);
        }

        int result = solveRecMemo(n - 1, num, target, dp);
        return result != 1e9 ? result : -1;
    }

    /**
     * Memoization Approach
     *
     * @param index
     * @param num
     * @param target
     * @param dp
     * @return
     */
    private static int solveRecMemo(int index, int[] num, int target, int[][] dp) {

        // base case --> for index 0 --> coin value should be able to divide target
        if (index == 0) {
            if (target % num[index] == 0) {
                return target / num[index];
            }
            return (int) Math.pow(10,9);
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notPick = solveRecMemo(index - 1, num, target, dp);
        int pick = (int) Math.pow(10, 9);

        if (num[index] <= target) {
            // here we add +1 so that count of coins is increased
            pick = 1 + solveRecMemo(index, num, target - num[index], dp);
        }

        return dp[index][target] = Math.min(notPick, pick);
    }

    /**
     * tabulation approach
     *
     * @param num
     * @param target
     * @return
     */
    public static int minimumCoinsTabulation(int num[], int target) {

        // Step 1 --> declare DP array
        int n = num.length;
        int[][] dp = new int[n][target + 1];

        // Step 2 --> base condition
        // why looping from 0 --> target == dp[0][target] needs to be checked for each a[0]
        for (int i = 0; i <= target; i++) {
            if (i % num[0] == 0) {
                dp[0][i] = target / num[0];
            } else {
                dp[0][i] = (int) Math.pow(10,9);
            }
        }
        // Step 3 --> form loops
        for (int index = 1; index < n; index++) {
            for (int currTarget = 0; currTarget <= target; currTarget++) {
                int notPick = dp[index - 1][currTarget];
                int pick = (int) Math.pow(10,9);
                if (num[index] <= currTarget) {
                    pick = 1 + dp[index][currTarget - num[index]];
                }
                dp[index][currTarget] = Math.min(notPick, pick);
            }
        }

        return dp[n - 1][target] != (int) Math.pow(10,9) ? dp[n - 1][target] : -1;
    }
}
