package com.leetCode.bitManipulation;

public class MaxXORForEachQuery {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 3};
        getMaximumXor(nums, 2);
    }

    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int xorAll = 0;
        for (int i = 0; i < n; i++) {
            xorAll ^= nums[i];
        }

        int maxXor = (1 << maximumBit) - 1;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = xorAll ^ maxXor;
            xorAll ^= nums[n - 1 - i];
        }
        return ans;
    }
}
