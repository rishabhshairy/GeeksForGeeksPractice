package com.leetCode.greedy.medHard;

import java.util.Arrays;

public class JumpGame2 {
    public static void main(String[] args) {

    }

    public int jump(int[] nums) {
        int n = nums.length;
        int jump = 0, left = 0, right = 0;
        while (right < n - 1) {
            int farthest = 0;
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            left = right + 1;
            right = farthest;
            jump++;
        }
        return jump;
    }

    /**
     * Tabulation
     *
     * @param nums
     * @return
     */
    public int jumpDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int mini = nums.length;
            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                if (i + j <= n - 1 && 1 + dp[i + j] < mini) {
                    mini = 1 + dp[i + j];
                }
            }
            dp[i] = mini;
        }
        return dp[0];
    }

    /**
     * Recursive approach
     *
     * @param nums
     * @return
     */
    public int jumpRecMemo(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solveRecMemo(0, nums, dp);
    }

    private int solveRecMemo(int index, int[] nums, int[] dp) {
        if (index >= nums.length - 1) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int mini = nums.length;
        for (int i = 1; i <= nums[index]; i++) {
            mini = Math.min(mini, 1 + solveRecMemo(index + i, nums, dp));
        }
        return dp[index] = mini;
    }
}
