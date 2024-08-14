package com.dynamicProgramming.Subsequences;

import java.util.Arrays;

/**
 * This solution works only for positive integers
 */
public class DP16PartitionSetWithMinAbsoluteDifference {
    public static void main(String[] args) {
        int[] arr = {8, 6, 5};
        int result = minSubsetSumDifference(arr, arr.length);
        System.out.println(result);
    }

    /**
     * We will first write the tabulation for subset sum of equals k
     * here k will be total sum of array
     *
     * @param arr
     * @param n
     * @return
     */
    public static int minSubsetSumDifference(int[] arr, int n) {
        // Write your code here.
        int totalSum = Arrays.stream(arr).sum();
        boolean[][] dp = new boolean[n][totalSum + 1];
        int s1 = 0;
        int s2 = 0;
        int minDiff = Integer.MAX_VALUE;
        // Set true for all 0 target
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        // Set true for particular sum
        if (arr[0] <= totalSum) {
            dp[0][arr[0]] = true;
        }

        for (int i = 1; i < n; i++) { // iterating array
            for (int j = 1; j <= totalSum; j++) { // iterating target
                boolean notPicked = dp[i - 1][j];
                boolean picked = false;
                if (arr[i] <= j) { // current element should be less than target
                    picked = dp[i - 1][j - arr[i]];
                }
                dp[i][j] = picked || notPicked;

                if (dp[i][j]) {
                    s1 = j;
                    s2 = totalSum - s1;
                    minDiff = Math.min(minDiff, Math.abs(s1 - s2));
                }
            }
        }
        return minDiff;
    }
}
