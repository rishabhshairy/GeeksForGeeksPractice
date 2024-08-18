package com.leetCode.arrays;

public class RunningSum1d {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        if (nums.length == 1) {
            return ans;
        }

        for (int i = 1; i < nums.length; i++) {
            ans[i] += ans[i - 1] + nums[i];
        }
        return ans;
    }
}
