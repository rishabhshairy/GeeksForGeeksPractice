package com.dynamicProgramming.OneDimensionDP;

public class ClimbStairs {
    public static void main(String[] args) {
        int n = 40;
        long way = climbStairs(n);
        System.out.println(way);
    }

    /**
     * this is recursive solution
     *
     * @param stairs
     * @return
     */
    public static long countDistinctWayToClimbStairRecursion(int stairs) {
        // Write your code here.
        if (stairs <= 1) {
            return 1;
        }

        return countDistinctWayToClimbStairRecursion(stairs - 1) + countDistinctWayToClimbStairRecursion(stairs - 2);
    }

    /**
     * Converting recursion to memoization
     * top-down
     *
     * @param n
     * @return
     */
    public static long climbStairs(int n) {
        long[] dp = new long[n + 1];

        if (n <= 1) {
            return 1;
        }

        dp[n - 1] = climbStairs(n - 1);
        dp[n - 2] = climbStairs(n - 2);
        return dp[n - 1] + dp[n - 2];
        // return dp[n]=climbStairs(n - 1)+climbStairs(n - 2);
    }

    /**
     * Top down approach
     * Space optimization will be similar to fibonacci
     * @param n
     * @return
     */
    public static long climbStairsTopDown(int n) {
        long[] dp = new long[n + 1];
        if (n <= 1) {
            return 1;
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
