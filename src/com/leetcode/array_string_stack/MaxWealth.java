package com.leetcode.array_string_stack;

public class MaxWealth {
    public static void main(String[] args) {
        int[][] a = {{1, 5}, {7, 3}, {3, 5}};
        System.out.println(maximumWealth(a));
    }

    static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                sum += accounts[i][j];
            }
            maxWealth = Math.max(maxWealth, sum);
        }
        return maxWealth;
    }
}
