package com.leetcode.DP;

public class MinCostTravel {
    public static void main(String[] args) {
        int[][] cost = {{14, 15, 16}, {14, 15, 16}, {14, 15, 16}};
        findCost(cost.length, cost);
    }

    public static void findCost(int n, int[][] cost) {
        if (n == 0 || cost == null || cost.length == 0) {
            System.out.println(0);
        }
        int col = cost[0].length;
        int[][] dp = new int[n][col];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < col && k != j; k++) {
                    cost[i][j] += Math.min(cost[i][j], cost[i][k]);
                }
            }
        }
        System.out.println(cost[n-1][col-1]);
    }
}
