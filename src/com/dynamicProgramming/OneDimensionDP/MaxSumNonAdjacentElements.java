package com.dynamicProgramming.OneDimensionDP;

import java.util.Arrays;
import java.util.List;

/**
 * @author rshairy
 * Problems which can be solved using this method
 * https://leetcode.com/problems/house-robber/description/
 * https://www.naukri.com/code360/problems/maximum-sum-of-non-adjacent-elements_843261
 */
public class MaxSumNonAdjacentElements {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 1, 3, 5, 8, 1, 9);
//        System.out.println(maximumNonAdjacentSumRecurrence(nums));
        System.out.println(maximumNonAdjacentSumMemoization(nums));
    }

    /**
     * This is recurrence solution
     *
     * @param nums
     * @return
     */
    public static int maximumNonAdjacentSumRecurrence(List<Integer> nums) {
        // Write your code here.
        int index = nums.size();
        return solveRecurrence(index - 1, nums);
    }

    private static int solveRecurrence(int index, List<Integer> nums) {
        if (index == 0) {
            return nums.get(index);
        }
        // Adding extra base case for negative index check
        if (index < 0) {
            return 0;
        }

        int sumPick = nums.get(index) + solveRecurrence(index - 2, nums);
        int sumNonPick = 0 + solveRecurrence(index - 1, nums);

        return Math.max(sumPick, sumNonPick);
    }


    /**
     * Memoization approach
     *
     * @param nums
     * @return
     */
    public static int maximumNonAdjacentSumMemoization(List<Integer> nums) {
        int[] dp = new int[nums.size() + 1];
        Arrays.fill(dp, -1);
        int index = nums.size() - 1;

        return solveMemo(index, dp, nums);
    }

    private static int solveMemo(int index, int[] dp, List<Integer> nums) {
        if (index == 0) {
            return nums.get(index);
        }
        // Adding extra base case for negative index check
        if (index < 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int sumPick = nums.get(index) + solveMemo(index - 2, dp, nums);
        int sumNonPick = 0 + solveMemo(index - 1, dp, nums);

        return dp[index] = Math.max(sumPick, sumNonPick);
    }

    /**
     * Tabulation Approach
     *
     * @param nums
     * @return
     */
    public static int maximumNonAdjacentSumTabulation(List<Integer> nums) {
        int[] dp = new int[nums.size()];
        int neg = 0; // Since we cannot store negative indexes
        Arrays.fill(dp, -1);
        dp[0] = nums.get(0);

        for (int index = 1; index < nums.size(); index++) {
            int sumPick = nums.get(index);
            // If there are at least two elements before the current element, add the value from dp[i-2].
            if (index > 1) {
                sumPick += dp[index - 2];
            }
            int nonPick = dp[index - 1];
            dp[index] = Math.max(sumPick, nonPick);
        }
        return dp[nums.size() - 1];
    }

    /** Space optimization
     * TC --> O(n)
     * SC --< O(1)
     * @param nums
     * @return
     */
    public static int maximumNonAdjacentSumSpaceOptimised(List<Integer> nums) {
        int prev = nums.get(0); // dp[0] or i-1
        int prev2 = 0;          // neg  or i-2

        for (int index = 1; index < nums.size(); index++) {
            int sumPick = nums.get(index);
            if (index > 1) {
                sumPick += prev2;
            }
            int sumNonPick = prev;
            int currSum = Math.max(sumPick, sumNonPick);
            prev2 = prev;
            prev = currSum;
        }
        return prev;
    }

}
