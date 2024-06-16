package com.leetCode.array_string_stack;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }

    static int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        } else {
            int[] minCost = new int[cost.length + 1];

            minCost[0] = 0;
            minCost[1] = 0;

            for (int i = 2; i <= cost.length; i++) {
                minCost[i] = Math.min(minCost[i - 1] + cost[i - 1], minCost[i - 2] + cost[i - 2]);
            }

            return minCost[cost.length];
        }
    }
}
