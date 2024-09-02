package com.dynamicProgramming.LIS;

import java.util.Arrays;

public class DP41LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {5, 4, 11, 1, 16, 8};
//        System.out.println(longestIncreasingSubsequence(arr));
//        System.out.println(longestIncreasingSubsequenceTabulation(arr));
        System.out.println(longestIncreasingSubsequenceTabulationOptimised(arr));

    }

    public static int longestIncreasingSubsequence(int[] arr) {
        //Your code goes here
        int n = arr.length;
        int[][] dp = new int[n][n + 1];

        for (int[] row :
                dp) {
            Arrays.fill(row, -1);
        }

        return solveRecMemo(0, -1, arr, dp);
    }

    private static int solveRecMemo(int index, int prevIndex, int[] arr, int[][] dp) {

        if (index == arr.length) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        int notTake = 0 + solveRecMemo(index + 1, prevIndex, arr, dp);
        int take = 0;

        if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
            take = 1 + solveRecMemo(index + 1, index, arr, dp);

        }

        return dp[index][prevIndex + 1] = Math.max(take, notTake);

    }

    /**
     * Tabulation
     * Use index shift
     * ind = n-1 --> 0
     * prevIndex = ind - 1 --> -1
     *
     * @param arr
     * @return
     */
    public static int longestIncreasingSubsequenceTabulation(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][n + 1];

        // form loops
        for (int index = n - 1; index >= 0; index--) {
            for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {

                int notTake = dp[index + 1][prevIndex + 1];
                int take = 0;

                if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
                    take = 1 + dp[index + 1][index + 1];

                }
                dp[index][prevIndex + 1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    /**
     * Space Optimised
     */
    public static int longestIncreasingSubsequenceTabulationOptimised(int[] arr) {
        int n = arr.length;
        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];


        // form loops
        for (int index = n - 1; index >= 0; index--) {
            for (int prevIndex = index - 1; prevIndex >= -1; prevIndex--) {

                int notTake = next[prevIndex + 1];
                int take = 0;

                if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
                    take = 1 + next[index + 1];

                }
                curr[prevIndex + 1] = Math.max(take, notTake);
            }
            next = curr;
        }
        return next[0];
    }
}
