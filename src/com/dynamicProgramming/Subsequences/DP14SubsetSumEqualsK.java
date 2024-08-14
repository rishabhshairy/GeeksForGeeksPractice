package com.dynamicProgramming.Subsequences;

import java.util.Arrays;

public class DP14SubsetSumEqualsK {
    public static void main(String[] args) {

    }

    /**
     * Recursion and Memoization approach
     *
     * @param n
     * @param k
     * @param arr
     * @return
     */
    public static boolean subsetSumToKRecurseMemo(int n, int k, int[] arr) {
        // Write your code here.
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solveRecMemo(n - 1, k, arr, dp);
    }

    private static boolean solveRecMemo(int index, int target, int[] arr, int[][] dp) {
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return arr[0] == target;
        }

        if (dp[index][target] != -1) {
            return dp[index][target] == -1;
        }

        boolean notPicked = solveRecMemo(index - 1, target, arr, dp);
        boolean picked = false;
        if (arr[index] <= target) {
            picked = solveRecMemo(index - 1, target - arr[index], arr, dp);
        }
        dp[index][target] = notPicked || picked ? 1 : -1;
        return notPicked || picked;
    }

    /**
     * Tabulation approach
     *
     * @param n
     * @param target
     * @param arr
     * @return
     */
    public static boolean subsetSumToKTabulation(int n, int target, int arr[]) {
        // Write your code here.
        boolean[][] dp = new boolean[n][target + 1];
        // base case 1
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        // base case 2 when arr[0] == target
        if (arr[0] <= target)
            dp[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                boolean notPicked = dp[i - 1][j];
                boolean picked = false;
                if (arr[i] <= j) {
                    picked = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = picked || notPicked;
            }
        }
        return dp[n - 1][target];
    }

    /**
     * Space Optimised Solution
     *
     * @param n
     * @param target
     * @param arr
     * @return
     */
    public static boolean subsetSumToKSpaceOptimised(int n, int target, int arr[]) {
        boolean[] prevRow = new boolean[target + 1];

        prevRow[0] = true;

        if (arr[0] <= target) {
            prevRow[arr[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            boolean[] currRow = new boolean[target + 1];
            currRow[0] = true;

            for (int j = 1; j <= target; j++) {
                boolean notPicked = prevRow[j];

                boolean picked = false;
                if (arr[i] <= j) {
                    picked = prevRow[j - arr[i]];
                }
                currRow[j] = picked || notPicked;
            }
            prevRow = currRow;
        }
        return prevRow[target];
    }
}
