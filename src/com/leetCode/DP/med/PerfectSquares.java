package com.leetCode.DP.med;


import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {
    public static void main(String[] args) {
        PerfectSquares obj = new PerfectSquares();
        obj.numSquares(123114567);
    }

    public int numSquares(int n) {
        List<Integer> allSquares = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i * i <= n) {
                allSquares.add(i * i);
            } else {
                break;
            }
        }
        int[] dp = new int[n + 1];

        // base case -- check if we are able to make sum
        for (int sum = 0; sum <= n; sum++) {
            if (sum % allSquares.get(0) == 0) {
                dp[sum] = sum / allSquares.get(0);
            } else {
                dp[sum] = (int) Math.pow(10, 9);
            }
        }


        for (int i = 1; i < allSquares.size(); i++) {
            for (int currSum = 0; currSum <= n; currSum++) {
                int notTake = dp[currSum];
                int take = (int) Math.pow(10, 9);
                if (allSquares.get(i) <= currSum) {
                    take = 1 + dp[currSum - allSquares.get(i)]; // reduce crr sum by number
                }
                dp[currSum] = Math.min(take, notTake);
            }
        }
        return dp[n];
    }
}
