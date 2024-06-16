package com.leetCode.DP;

public class CountingBits {
    public static void main(String[] args) {
        int n = 24;
        countBits(n);
    }

    public static int[] countBits(int n) {
/*            int[] nums = new int[n+1];
            for (int i = 0; i <= n; i++) {
                String remZero = Integer.toString(i, 2).replaceAll("0", "");
                nums[i] = remZero.length();
                System.out.println(nums[i]);
            }
            return nums;*/
        // DP Solution below

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = 1 + dp[i - 1];
            }
        }
        return dp;

    }
}
