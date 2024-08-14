package com.dynamicProgramming.Subsequences;

import java.util.Arrays;
import java.util.HashMap;

/**
 * We can boil down this question to count partition with s1-s2=target
 * which can be further boiled down to subset sum with target
 */
public class DP21TargetSum {
    public static void main(String[] args) {

    }

    /**
     * This is naive approach
     * where we check for each possible operation on +/-
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, HashMap<Integer, Integer>> dpMap = new HashMap<>();

        return totalWays(n - 1, nums, target, dpMap);
    }

    private int totalWays(int index, int[] nums, int target, HashMap<Integer, HashMap<Integer, Integer>> dpMap) {

        // base condition
        if (index == 0) {
            // since both ways can add up to answer
            int ways = 0;

            if (target - nums[index] == 0) {
                ways++;
            }
            if (target + nums[index] == 0) {
                ways++;
            }

            return ways;
        }

        // using dpMap since we cannot store negative index in table
        if (dpMap.containsKey(index)) {
            if (dpMap.get(index).containsKey(target)) {
                return dpMap.get(index).get(target);
            }
        }

        int addition = totalWays(index - 1, nums, target + nums[index], dpMap);
        int subtraction = totalWays(index - 1, nums, target - nums[index], dpMap);

        int totalWays = addition + subtraction;
        // Memoizing now
        HashMap<Integer, Integer> targetWayMap = new HashMap<>();
        targetWayMap.put(target, totalWays);
        dpMap.put(index, targetWayMap);

        return totalWays;
    }

    /**
     * this is advanced approach
     *
     * @param n
     * @param target
     * @param arr
     * @return
     */
    public static int targetSum(int n, int target, int[] arr) {
        // Write your code here.
        int totalSum = Arrays.stream(arr).sum();
        int targetDifference = (totalSum - target);

        if (targetDifference < 0 || targetDifference % 2 != 0) {
            return 0;
        }


        int targetCol = targetDifference / 2; // new target for subset
        int[][] dp = new int[n][targetCol + 1];

        // base case
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        if (arr[0] <= targetCol) {
            dp[0][targetCol] = arr[0];
        }

        if (arr[0] == 0) {
            dp[0][0] = 2;
        }

        for (int index = 1; index < n; index++) {
            for (int j = 0; j <= targetCol; j++) {
                int notPick = dp[index - 1][j];
                int pick = 0;
                if (arr[index] <= j) {
                    pick = dp[index - 1][j - arr[index]];
                }
                dp[index][j] = notPick + pick;
            }
        }

        return dp[n - 1][targetCol];
    }
}
