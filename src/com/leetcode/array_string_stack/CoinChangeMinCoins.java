package com.leetcode.array_string_stack;

public class CoinChangeMinCoins {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] tdp = new int[n + 1][amount + 1];

        // intialize
        for (int i = 0; i < amount + 1; i++) {
            tdp[0][i] = Integer.MAX_VALUE - 1;
        }
        for (int i = 1; i < n + 1; i++) {
            tdp[i][0] = 0;
        }

        //evaluate dp
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] <= j) {
                    tdp[i][j] = Math.min(1 + tdp[i][j - coins[i - 1]], tdp[i - 1][j]);
                } else {
                    tdp[i][j] = tdp[i - 1][j];
                }

            }
        }
        return tdp[n][amount] == Integer.MAX_VALUE - 1 ? -1 : tdp[n][amount];
    }
}
