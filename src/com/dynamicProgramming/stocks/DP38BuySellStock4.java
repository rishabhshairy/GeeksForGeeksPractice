package com.dynamicProgramming.stocks;

import java.util.Arrays;

/**
 * LC
 * We can do at max K transactions
 * Similar to BuySell Stock 3 where we had at max 2 transactions
 */
public class DP38BuySellStock4 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k + 1]; // 3rd dimension is 3 because transaction can be 0,1,2

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int canBuy = 1;
        return solveMemo(0, canBuy, k, prices, dp);
    }

    private static int solveMemo(int index, int canBuy, int maxTransaction, int[] prices, int[][][] dp) {
        // base case
        if (index == prices.length || maxTransaction == 0) {
            return 0;
        }

        // memoized value
        if (dp[index][canBuy][maxTransaction] != -1) {
            return dp[index][canBuy][maxTransaction];
        }
        int profit = 0;
        if (canBuy == 1) {
            int buy = -prices[index] + solveMemo(index + 1, 0, maxTransaction, prices, dp);
            int notBuy = solveMemo(index + 1, 1, maxTransaction, prices, dp);
            profit = Math.max(buy, notBuy);

        }
        if (canBuy == 0) {
            int sell = prices[index] + solveMemo(index + 1, 1, maxTransaction - 1, prices, dp);
            int notSell = solveMemo(index + 1, 0, maxTransaction, prices, dp);
            profit = Math.max(sell, notSell);
        }
        dp[index][canBuy][maxTransaction] = profit;
        return profit;
    }
}
