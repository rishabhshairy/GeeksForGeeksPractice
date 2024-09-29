package com.dynamicProgramming.stocks;

import java.util.Arrays;

/**
 * Buy as many times
 * Sell as many times
 */
public class DP36BuySellStock2 {
    public static void main(String[] args) {
        System.out.println(getMaximumProfitTabSpaceOptimised(6, new long[]{7, 1, 5, 3, 6, 4}));
    }

    /**
     * Recursive and memo
     *
     * @param n
     * @param values
     * @return
     */
    public static long getMaximumProfitRecMemo(int n, long[] values) {
        // Your code goes here.
        long[][] dp = new long[n][2];
        for (long[] row :
                dp) {
            Arrays.fill(row, -1);
        }
        int canBuy = 1;

        return solveRecMemo(0, canBuy, values, dp);
    }

    private static long solveRecMemo(int index, int canBuy, long[] values, long[][] dp) {


        if (index == values.length) {
            return 0;
        }

        if (dp[index][canBuy] != -1) {
            return dp[index][canBuy];
        }
        long profit = 0;
        if (canBuy == 1) {

            long buy = -values[index] + solveRecMemo(index + 1, 0, values, dp);
            long notBuy = solveRecMemo(index + 1, 1, values, dp);
            profit = Math.max(buy, notBuy);

        } else {
            long sell = values[index] + solveRecMemo(index + 1, 1, values, dp);
            long notSell = solveRecMemo(index + 1, 0, values, dp);
            profit = Math.max(sell, notSell);
        }
        return dp[index][canBuy] = profit;
    }

    /**
     * Tabulation
     *
     * @param n
     * @param values
     * @return
     */
    public static long getMaximumProfitTabulation(int n, long[] values) {
        // Your code goes here.
        long[][] dp = new long[n + 1][2];
        long profit = 0;

        // base case --> When we have no stock to buy/sell
        dp[n][0] = dp[n][1] = 0;

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {

                if (canBuy == 0) {
                    long buy = -values[index] + dp[index + 1][1];
                    long notBuy = dp[index + 1][0];
                    profit = Math.max(buy, notBuy);
                }

                if (canBuy == 1) { // selling stocks
                    long sell = values[index] + dp[index + 1][0];
                    long notSell = dp[index + 1][1];
                    profit = Math.max(sell, notSell);
                }
                dp[index][canBuy] = profit;
            }
        }
        return dp[0][0];
    }

    public static long getMaximumProfitTabSpaceOptimised(int n, long[] values) {
        // Your code goes here.
        long[] ahead = new long[2];
        long[] curr = new long[2];
        long profit = 0;

        // base case --> When we have no stock to buy/sell
        ahead[0] = ahead[1] = 0;

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {

                if (canBuy == 0) {
                    long buy = -values[index] + ahead[1];
                    long notBuy = ahead[0];
                    profit = Math.max(buy, notBuy);
                }

                if (canBuy == 1) { // selling stocks
                    long sell = values[index] + ahead[0];
                    long notSell = ahead[1];
                    profit = Math.max(sell, notSell);
                }
                curr[canBuy] = profit;

            }
            ahead = curr;
        }
        return ahead[0];
    }
}
