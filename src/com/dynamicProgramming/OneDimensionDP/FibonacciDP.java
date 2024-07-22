package com.dynamicProgramming.OneDimensionDP;

import java.util.Arrays;

/**
 * Both Approach
 * Top Down --> Memoization
 * Bottom up --> Tabulation
 */
public class FibonacciDP {
    public static void main(String[] args) {
        System.out.println(topDown(853));
        System.out.println(bottomUp(853));
    }

    static long topDown(int n) {
        // code here
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);

        return findAnswer(dp, n) % 1000000007;

    }

    /**
     * This is memoization
     * where we are storing the result into DP array while computing the return statement
     * TC --> O(n)
     * SC --> O(n) + O(n)
     *
     * @param dp
     * @param n
     * @return
     */
    private static long findAnswer(long[] dp, int n) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = (findAnswer(dp, n - 1) % 1000000007) + (findAnswer(dp, n - 2) % 1000000007);
    }

    /**
     * This is tabulation
     *
     * @param n
     * @return
     */
    static long bottomUp(int n) {
        // code here
        long[] dp = new long[n + 1];
        if (n <= 1) {
            return n;
        }
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] % 1000000007 + dp[i - 2] % 1000000007;
        }
        return dp[n] % 1000000007;
    }
}
