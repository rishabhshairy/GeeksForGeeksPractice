package com.dynamicProgramming.stocks;

import java.util.ArrayList;

public class DP35BuySellStock1 {
    public static void main(String[] args) {
//        System.out.println(maximumProfit());
    }

    public static int maximumProfit(ArrayList<Integer> prices) {
        // Write your code here.
        int mini = prices.get(0);
        int profit = 0;
        for (int i = 1; i < prices.size(); i++) {
            int cost = prices.get(i) - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, prices.get(i));
        }
        return profit;
    }
}
