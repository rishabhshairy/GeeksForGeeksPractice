package com.leetcode.DP;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] houses = {2, 7, 9, 3, 1};
    }

    public int rob(int[] nums) {
/*        int[] mem = new int[101];
        Arrays.fill(mem, -1);
        int index = 0;
        return solve(nums, index, mem);
        memoization*/

        int n = nums.length;
        int[] dp = new int[n + 2];
        Arrays.fill(dp, -1);
        dp[n] = 0;
        dp[n + 1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int prof1 = nums[i] + dp[i + 2];
            int prof2 = dp[i + 1];
            dp[i] = Math.max(prof1, prof2);
        }
        return dp[0];
    }

    // memoiazation
    private int solve(int[] nums, int index, int[] mem) {
        if (index >= nums.length) {
            return 0;
        }
        if (mem[index] != -1) {
            return mem[index];
        }
        System.out.println(mem[index]);
        int pro1 = nums[index] + solve(nums, index + 2, mem);
        int pro2 = solve(nums, index + 1, mem);
        return mem[index] = Math.max(pro1, pro2);
    }
}
