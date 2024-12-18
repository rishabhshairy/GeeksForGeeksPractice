package com.leetCode.arrays;

public class TransformedArray {
    public static void main(String[] args) {
        int[] nums = {3, -2, 1, 1};
        TransformedArray obj = new TransformedArray();
        obj.constructTransformedArray(nums);
    }

    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int index = i;
            if (nums[i] > 0) {
                index = (i + nums[i]) % n;
            } else if (nums[i] < 0) {
                index = (n + (i + nums[i]) % n) % n;
            }
            result[i] = nums[index];
        }

        return result;
    }
}
