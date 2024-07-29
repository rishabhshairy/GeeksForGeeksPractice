package com.dynamicProgramming.OneDimensionDP;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/problems/geek-jump/1
 */
public class FrogJump {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 10};
        System.out.println(frogJumpRecurrence(4, arr));
    }

    /**
     * @param n
     * @param heights
     * @return
     */
    public static int frogJumpRecurrence(int n, int heights[]) {
        return findEnergy(n - 1, heights);

    }

    private static int findEnergy(int index, int[] heights) {
        if (index == 0) {
            return 0;
        }

        // do all stuffs with index
        int left = findEnergy(index - 1, heights) + Math.abs(heights[index] - heights[index - 1]);
        int right = Integer.MAX_VALUE;
        if (index > 1) {
            right = findEnergy(index - 2, heights) + Math.abs(heights[index] - heights[index - 2]);
        }
        return Math.min(left, right);
    }

    /**
     * This is memoization approach
     * TC --> O(n)
     * SC --> O(n)
     *
     * @param n
     * @param heights
     * @return
     */
    public static int frogJumpMemoization(int n, int heights[]) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return findEnergyBottomUp(n - 1, heights, dp);
    }

    private static int findEnergyBottomUp(int index, int[] heights, int[] dp) {
        // base case
        if (index == 0) {
            return 0;
        }

        // this step is to check if dp[index] is previously computed or not
        if (dp[index] != -1) {
            return dp[index];
        }

        // increment by one step
        int left = findEnergyBottomUp(index - 1, heights, dp) + Math.abs(heights[index] - heights[index - 1]);
        int right = Integer.MAX_VALUE;
        if (index > 1) {
            // increment by 2 steps
            right = findEnergyBottomUp(index - 2, heights, dp) + Math.abs(heights[index] - heights[index - 2]);
        }

        return dp[index] = Math.min(left, right);
    }

    /**
     * This is bottom up approach
     *
     * @param n
     * @param heights
     * @return
     */
    public static int frogJumpTabulation(int n, int heights[]) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int index = 1; index < n; index++) {
            int jumpTwoStep = Integer.MAX_VALUE;
            int jumpOneStep = dp[index - 1] + Math.abs(heights[index] - heights[index - 1]);

            if (index > 1) {
                jumpTwoStep = dp[index - 2] + Math.abs(heights[index] - heights[index - 2]);
            }
            dp[index] = Math.min(jumpOneStep, jumpTwoStep);
        }

        return dp[n - 1];
    }

    public static int frogJumpSpaceOptimised(int n, int[] heights) {
        int prevJumpOne = 0;
        int prevJumpTwo = 0;
        for (int index = 1; index < n; index++) {
            int jumpTwoStep = Integer.MAX_VALUE;
            int jumpOneStep = prevJumpOne + Math.abs(heights[index] - heights[index - 1]);

            if (index > 1) {
                jumpTwoStep = prevJumpTwo + Math.abs(heights[index] - heights[index - 2]);
            }

            int currJump = Math.min(jumpOneStep, jumpTwoStep);
            prevJumpTwo = prevJumpOne;
            prevJumpOne = currJump;

        }
        return prevJumpOne;
    }

}
