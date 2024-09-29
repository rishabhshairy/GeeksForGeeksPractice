package com.dynamicProgramming.LIS;

import java.util.Arrays;

public class DP47NumberOfLIS {
    public static void main(String[] args) {

    }

    public static int findNumberOfLIS(int[] arr) {
        // Write your code here.
        int n = arr.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);
        Arrays.fill(dp, 1);
        int maxi = 0;

        for (int index = 0; index < n; index++) {
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                if (arr[prevIndex] < arr[index] && 1 + dp[prevIndex] > dp[index]) {
                    dp[index] = 1 + dp[prevIndex];
                    // inherit
                    count[index] = count[prevIndex];

                } else if (arr[prevIndex] < arr[index] && 1 + dp[prevIndex] == dp[index]) {
                    // when you encounter same length --> increase the count
                    count[index] += count[prevIndex];
                }
            }
            maxi = Math.max(maxi, dp[index]);

        }

        int lisCounts = 0;

        for (int index = 0; index < n; index++) {
            if (dp[index] == maxi) {
                lisCounts += count[index];
            }
        }

        return lisCounts;
    }
}
