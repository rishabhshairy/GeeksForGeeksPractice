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
        System.out.println(bottomUpSpaceOptimised(853));
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
     * * TC --> O(n)
     * * SC --> O(n)
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

    /**
     * Intuition here since we are just calculating numbers we don't require arrays to store it
     * TC --> O(n)
     * SC --> O(1)
     *
     * @param n
     * @return
     */
    static long bottomUpSpaceOptimised(int n) {
        if (n <= 1) {
            return n;
        }
        int prev1 = 0;
        int prev2 = 1;

        for (int i = 2; i <= n; i++) {
            int curr = prev1 % 1000000007 + prev2 % 1000000007;
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2 % 1000000007;
    }
}
