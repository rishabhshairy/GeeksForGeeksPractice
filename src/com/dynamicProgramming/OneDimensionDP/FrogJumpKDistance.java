package com.dynamicProgramming.OneDimensionDP;

import java.util.Arrays;

/**
 * GFG --> https://www.geeksforgeeks.org/problems/minimal-cost/1
 */
public class FrogJumpKDistance {
    public static void main(String[] args) {
        int[] heights = {10, 30, 40, 50, 20};
        System.out.println(minimizeCostTabulation(heights, heights.length, 3));
    }

    public static int minimizeCostRecurrence(int arr[], int n, int k) {
        // code here
        return solve(arr, n - 1, k);
    }

    private static int solve(int[] heights, int index, int k) {
        if (index == 0) {
            return 0;
        }
        int minSteps = Integer.MAX_VALUE;
        for (int jump = 1; jump <= k; jump++) {
            if (index - jump >= 0) {
                int cost = solve(heights, index - jump, k) + Math.abs(heights[index] - heights[index - jump]);
                minSteps = Math.min(minSteps, cost);
            }
        }
        return minSteps;
    }

    /**
     * Memoization
     */
    public static int minimizeCostMemoization(int arr[], int n, int k) {
        // code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solveMemoization(arr, n - 1, k, dp);
    }

    private static int solveMemoization(int[] heights, int index, int k, int[] dp) {
        if (index == 0) {
            return 0;
        }
        // check for memoized value
        if (dp[index] != -1) {
            return dp[index];
        }

        int minSteps = Integer.MAX_VALUE;
        for (int jump = 1; jump <= k; jump++) {
            if (index - jump >= 0) {
                int cost = solveMemoization(heights, index - jump, k, dp) + Math.abs(heights[index] - heights[index - jump]);
                minSteps = Math.min(minSteps, cost);
            }
        }
        return dp[index] = minSteps;
    }

    /**
     * Tabulation
     */
    public static int minimizeCostTabulation(int arr[], int n, int k) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int index = 1; index < n; index++) {

            int minSteps = Integer.MAX_VALUE;

            for (int jump = 1; jump <= k; jump++) {
                if (index - jump >= 0) {
                    int cost = dp[index - jump] + Math.abs(arr[index] - arr[index - jump]);
                    minSteps = Math.min(minSteps, cost);
                }
            }

            dp[index] = minSteps;
        }
        return dp[n - 1];
    }
}
