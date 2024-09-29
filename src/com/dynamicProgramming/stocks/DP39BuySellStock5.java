package com.dynamicProgramming.stocks;

import java.util.Arrays;

/**
 * Buy Sell Stock with CoolDown
 * after one transaction we need one cool down
 */
public class DP39BuySellStock5 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] row :
                dp) {
            Arrays.fill(row, -1);
        }
        int canBuy = 1;
        return solveRecMemo(0, canBuy, prices, dp);
    }

    private int solveRecMemo(int index, int canBuy, int[] prices, int[][] dp) {
        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][canBuy] != -1) {
            return dp[index][canBuy];
        }

        int profit = 0;

        if (canBuy == 1) {
            int buy = -prices[index] + solveRecMemo(index + 1, 0, prices, dp);
            int notBuy = solveRecMemo(index + 1, 1, prices, dp);
            profit = Math.max(buy, notBuy);
        } else {
            int sell = prices[index] + solveRecMemo(index + 2, 1, prices, dp);
            int notSell = solveRecMemo(index + 1, 0, prices, dp);
            profit = Math.max(sell, notSell);
        }

        return dp[index][canBuy] = profit;
    }
}
