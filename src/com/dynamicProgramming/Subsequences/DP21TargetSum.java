package com.dynamicProgramming.Subsequences;

import java.util.Arrays;

/**
 * We can boil down this question to count partition with s1-s2=target
 * which can be further boiled down to subset sum with target
 */
public class DP21TargetSum {
    public static void main(String[] args) {

    }

    /**
     * @param n
     * @param target
     * @param arr
     * @return
     */
    public static int targetSum(int n, int target, int[] arr) {
        // Write your code here.
        int totalSum = Arrays.stream(arr).sum();
        int targetDifference = (totalSum - target);

        if (targetDifference < 0 || targetDifference % 2 != 0) {
            return 0;
        }


        int targetCol = targetDifference / 2; // new target for subset
        int[][] dp = new int[n][targetCol + 1];

        // base case
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        if (arr[0] <= targetCol) {
            dp[0][targetCol] = arr[0];
        }

        if (arr[0] == 0) {
            dp[0][0] = 2;
        }

        for (int index = 1; index < n; index++) {
            for (int j = 0; j <= targetCol; j++) {
                int notPick = dp[index - 1][j];
                int pick = 0;
                if (arr[index] <= j) {
                    pick = dp[index - 1][j - arr[index]];
                }
                dp[index][j] = notPick + pick;
            }
        }

        return dp[n - 1][targetCol];
    }
}
