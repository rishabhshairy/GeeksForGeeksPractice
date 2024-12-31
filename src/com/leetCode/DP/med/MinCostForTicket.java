package com.leetCode.DP.med;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinCostForTicket {
    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] cost = {2, 7, 15};
        MinCostForTicket obj = new MinCostForTicket();
        int minCost = obj.mincostTickets(days, cost);
        System.out.println(minCost);
    }

    private int mincostTickets(int[] days, int[] cost) {
        int maxDay = days[days.length - 1];
        Set<Integer> daySet = new HashSet<>();

        // put all days in set
        for (int i = 0; i < days.length; i++) {
            daySet.add(days[i]);
        }

        int[] dp = new int[maxDay + 1];

        for (int currentDay = 1; currentDay <= maxDay; currentDay++) {
            if (!daySet.contains(currentDay)) {
                dp[currentDay] = dp[currentDay - 1];
//                System.out.println("Day="+currentDay+" val="+dp[currentDay]);

            } else {
                int oneDay = dp[currentDay - 1] + cost[0];
                int sevenDayPass = dp[Math.max(0, currentDay - 7)] + cost[1]; // taking max (0, currDay-7) to avoid negative index
                int thirtyDayPass = dp[Math.max(0, currentDay - 30)] + cost[2];
//                System.out.println("OneDay=" + oneDay + " SevenDay=" + sevenDayPass + " thirtyDay=" + thirtyDayPass);
                dp[currentDay] = Math.min(oneDay, Math.min(sevenDayPass, thirtyDayPass));
            }
        }
        return dp[maxDay];
    }

    /**
     * Recursive and Memoization
     * Approach
     *
     * @param days
     * @param costs
     * @return
     */
    public int mincostTicketsRecursive(int[] days, int[] costs) {
        Set<Integer> daySet = new HashSet<>();
        for (int i = 0; i < days.length; i++) {
            daySet.add(days[i]);
        }
        int[] dp = new int[365];
        Arrays.fill(dp, -1);
        return solve(1, days, costs, daySet, dp);
    }

    private int solve(int currentDay, int[] days, int[] costs, Set<Integer> daySet, int[] dp) {

        if (currentDay > days[days.length - 1]) {
            return 0;
        }

        if (!daySet.contains(currentDay)) {
            return solve(currentDay + 1, days, costs, daySet, dp);
        }
        if (dp[currentDay] != -1) {
            return dp[currentDay];
        }

        int oneDayPass = costs[0] + solve(currentDay + 1, days, costs, daySet, dp);
        int sevenDayPass = costs[1] + solve(currentDay + 7, days, costs, daySet, dp);
        int thirtyDayPass = costs[2] + solve(currentDay + 30, days, costs, daySet, dp);

        return dp[currentDay] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
    }
}
