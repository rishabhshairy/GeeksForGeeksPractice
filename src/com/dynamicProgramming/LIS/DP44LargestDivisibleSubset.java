package com.dynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP44LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] arr = {1, 16, 7, 8, 4};
    }

    /**
     * Use same logic of LIS printing and instead of checking greater
     * just check divisibility
     *
     * @param arr
     * @return
     */
    public static List<Integer> divisibleSet(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];

        int maxi = 1;
        int lastIndex = 0;

        for (int index = 1; index < n; index++) {
            hash[index] = index;
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                if (arr[index] % arr[prevIndex] == 0 && 1 + dp[prevIndex] > dp[index]) {
                    dp[index] = 1 + dp[prevIndex];
                    hash[index] = prevIndex;
                }
            }
            if (dp[index] > maxi) {
                maxi = dp[index];
                lastIndex = index;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(arr[lastIndex]);

        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            result.add(arr[lastIndex]);
        }
        return result;
    }

}
