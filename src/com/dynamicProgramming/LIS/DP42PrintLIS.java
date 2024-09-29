package com.dynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DP42PrintLIS {
    public static void main(String[] args) {
        int[] arr = {5, 4, 11, 1, 16, 8};
//        int[] arr = {1};
//        System.out.print(printLongestIncreasingSubsequence(arr.length, arr));
        System.out.print(longestIncreasingSubsequenceMinSpace(arr.length, arr));
    }

    public static ArrayList<Integer> printLongestIncreasingSubsequence(int n, int arr[]) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 1;
        int lastIndex = 0;

        for (int index = 0; index < n; index++) {
            hash[index] = index;
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                if (arr[prevIndex] < arr[index] && 1 + dp[prevIndex] > dp[index]) {
                    dp[index] = 1 + dp[prevIndex];
                    hash[index] = prevIndex;
                }
            }
            if (dp[index] > maxi) {
                maxi = dp[index];
                lastIndex = index;
            }
        }
//        System.out.println(lastIndex + " " + hash[lastIndex]);

        result.add(arr[lastIndex]);


        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            result.add(arr[lastIndex]);
        }
//        System.out.print(result);
        Collections.reverse(result);
        return result;
    }

    /**
     * Printing uses same concept of Single DP array and hash array
     *
     * @param n
     * @param arr
     * @return
     */
    public static int longestIncreasingSubsequenceMinSpace(int n, int[] arr) {
        // Another way of finding LIS
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;
        int lastIndex = 1;

        for (int index = 0; index < n; index++) {
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                System.out.println(arr[index] + " " + arr[prevIndex]);
                if (arr[prevIndex] < arr[index]) {
                    dp[index] = Math.max(dp[index], 1 + dp[prevIndex]);
                }
            }
            System.out.println("loopended");
            maxi = Math.max(maxi, dp[index]);
        }
        return maxi;
    }

}
