package com.leetcode.array_string_stack;

import java.util.Arrays;

public class MaxSumDivisibleBy3 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 5, 1, 8};
        MaxSumDivisibleBy3 divisibleBy3 = new MaxSumDivisibleBy3();
        System.out.println(divisibleBy3.maxSumDivThree(arr));
    }

    public int maxSumDivThree(int[] A) {
        int[] dp = new int[3];
        for (int a : A) {
            for (int i : Arrays.copyOf(dp, dp.length)) {
                dp[(i + a) % 3] = Math.max(dp[(i + a) % 3], i + a);
            }
        }
        return dp[0];
    }
}
