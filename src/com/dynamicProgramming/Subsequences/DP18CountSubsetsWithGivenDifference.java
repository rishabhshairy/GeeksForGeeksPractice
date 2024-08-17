package com.dynamicProgramming.Subsequences;

import java.util.Arrays;

public class DP18CountSubsetsWithGivenDifference {
    public static int countPartitions(int n, int d, int[] arr) {
        // Write your code here.
        int totalSum = Arrays.stream(arr).sum();
        int targetSum = totalSum - d;

        if (targetSum < 0 || targetSum % 2 != 0) {
            return 0;
        }

        return findPartitions(n, targetSum / 2, arr);
    }

    /**
     * Now this boils down to DP17
     * so directly writing tabulation logic
     *
     * @param n
     * @param i
     * @param arr
     * @return
     */
    private static int findPartitions(int n, int target, int[] arr) {
        int[][] dp = new int[n][target + 1];
        int mod = (int) (1e9 + 7);
        // base case
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        // if target at 0
        if (arr[0] <= target) {
            dp[0][arr[0]] = 1;
        }
        // if element is 0 at arr[0]
        if (arr[0] == 0) {
            dp[0][0] = 2;
        }

        // fill table
        for (int index = 1; index < n; index++) {
            for (int currTarget = 0; currTarget <= target; currTarget++) {

                int notPick = dp[index - 1][currTarget] % mod;

                int pick = 0;

                if (arr[index] <= currTarget) {
                    pick = dp[index - 1][currTarget - arr[index]] % mod;
                }

                dp[index][currTarget] = (pick + notPick) % mod;
            }
        }
        return dp[n - 1][target];
    }
}
