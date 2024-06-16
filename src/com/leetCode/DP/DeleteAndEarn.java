package com.leetCode.DP;

public class DeleteAndEarn {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 3, 3, 4};
        deleteAndEarn(arr);
    }

    public static int deleteAndEarn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[10004];
        int p1 = 0;
        int p2 = 0;

        for (int num : nums) {
            dp[num] += num;
        }

        for (int val : dp) {
            int temp = p1;
            p1 = Math.max(p2 + val, p1);
            p2 = temp;
        }
        return p1;
    }
}
