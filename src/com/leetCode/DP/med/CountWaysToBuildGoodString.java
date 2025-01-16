package com.leetCode.DP.med;

import java.util.Arrays;

/**
 * LC 2466
 */
public class CountWaysToBuildGoodString {
    public static void main(String[] args) {
        int low = 2;
        int high = 3;
        int zero = 1;
        int one = 2;
        CountWaysToBuildGoodString obj = new CountWaysToBuildGoodString();
        int ans = obj.countGoodStrings(low, high, zero, one);
        System.out.println(ans);
    }

    private int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1000000007;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int ans = 0;

        for (int index = 0; index <= high; index++) {
            if (index + zero <= high) {
                dp[index + zero] = (dp[index + zero] + dp[index]) % mod;
            }
            if (index + one <= high) {
                dp[index + one] = (dp[index + one] + dp[index]) % mod;
            }
        }

        // now count between low to high
        for (int index = low; index <= high; index++) {
            ans += dp[index] % mod;
        }
        return ans;
    }

    /**
     * Recursive and memoization approach
     *
     * @param low
     * @param high
     * @param zero
     * @param one
     * @return
     */
    public int countGoodStringsRecMemo(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        Arrays.fill(dp, -1);
        return solve(low, high, zero, one, 0, dp);
    }

    private int solve(int low, int high, int zero, int one, int index, int[] dp) {
        if (index > high) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index] % 1000000007;
        }

        int count = index >= low ? 1 : 0;
        int way1 = solve(low, high, zero, one, index + zero, dp) % 1000000007;
        int way2 = solve(low, high, zero, one, index + one, dp) % 1000000007;
        return dp[index] = way1 + way2 + count;
    }
}

