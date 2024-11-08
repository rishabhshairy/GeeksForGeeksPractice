package com.leetCode.greedy.medHard;

import java.util.Arrays;

/**
 * Lets Solve this using both DP and Greedy
 */
public class JumpGame {

    /**
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex) {
                return false;
            }
            maxIndex = Math.max(maxIndex, i + nums[i]);

        }
        return true;
    }

    /**
     * DP approach
     *
     * @param nums
     * @return
     */
    public boolean canJumpTabulation(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];

        // base case
        dp[n - 1] = true;

        // iterating over array
        for (int i = n - 2; i >= 0; i--) {
            // iterating for jump
            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                if (dp[i + j] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    /**
     * Rec Memo Solution
     *
     * @param nums
     * @return
     */
    public boolean canJumpRecMemo(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solveRecMemo(0, nums, dp);
    }

    private boolean solveRecMemo(int index, int[] nums, int[] dp) {
        // base case when we reach end index
        if (index >= nums.length - 1) {
            return true;
        }

        if (dp[index] != -1) {
            return dp[index] == 1;
        }
        // for each index we can do max jump of arr[index]

        for (int i = 1; i <= nums[index]; i++) {
            if (solveRecMemo(index + i, nums, dp)) {
                dp[index] = 1;
                return true;
            }
        }
        dp[index] = 0;
        return false;
    }
}
