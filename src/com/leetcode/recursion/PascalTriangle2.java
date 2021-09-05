package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {
    public static void main(String[] args) {
        int rowIndex = 3;
        getRow(rowIndex);
    }

    public static List<Integer> getRow(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        System.out.println(1%2);
        return Arrays.asList(dp);
    }
}
