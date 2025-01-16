package com.leetCode.DP.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSum3NonOverLapSubArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        int k = 2;
        MaxSum3NonOverLapSubArray obj = new MaxSum3NonOverLapSubArray();
        int[] arr = obj.maxSumOfThreeSubarrays(nums, k);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // number of possible starting position
        int n = nums.length - k + 1;
        int[] sums = new int[n];

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        sums[0] = windowSum;

        // use sliding window to update sums array
        for (int index = k; index < nums.length; index++) {
            windowSum = windowSum - nums[index - k] + nums[index];
            sums[index - k + 1] = windowSum;
        }

        int[][] dp = new int[n][4];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

        List<Integer> indices = new ArrayList<>();
        // find optimal result using dp
        solve(0, k, 3, sums, dp);

        // now do dfs for path re-construction
        dfs(sums, k, 0, 3, dp, indices);
        int[] result = new int[3];

        for (int i = 0; i < 3; i++) {
            result[i] = indices.get(i);
        }

        return result;
    }

    private void dfs(int[] sums, int k, int index, int remainder, int[][] dp, List<Integer> indices) {
        // all selected
        if (remainder == 0) {
            return;
        }

        // invalid path
        if (index >= sums.length) {
            return;
        }

        int take = sums[index] + solve(index + k, k, remainder - 1, sums, dp);
        int notTake = solve(index + 1, k, remainder, sums, dp);

        if (take >= notTake) {
            indices.add(index);
            dfs(sums, k, index + k, remainder - 1, dp, indices);
        } else {
            dfs(sums, k, index + 1, remainder, dp, indices);
        }
    }

    private int solve(int index, int k, int remainder, int[] sums, int[][] dp) {
        if (remainder == 0) {
            return 0;
        }
        if (index >= sums.length) {
            return remainder > 0 ? Integer.MIN_VALUE : 0;
        }

        if (dp[index][remainder] != -1) {
            return dp[index][remainder];
        }

        // take/notTake logic
        int take = sums[index] + solve(index + k, k, remainder - 1, sums, dp);
        int notTake = solve(index + 1, k, remainder, sums, dp);

        dp[index][remainder] = Math.max(take, notTake);
        return dp[index][remainder];
    }

}
