package com.neetcode150.arrays;

public class ProductOfArrayExceptSelf {

    /**
     * Division Methods
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int zeros = 0;
        for (int num : nums) {
            if (num != 0) {
                prod *= num;
            } else {
                zeros++;
            }
        }

        if (zeros > 1) {
            return new int[nums.length];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeros > 0) {
                result[i] = (nums[i] == 0) ? prod : 0;
            } else {
                result[i] = prod / nums[i];
            }
        }
        return result;
    }

    /**
     * Brute Force
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelfBruteForce(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    prod = prod * nums[j];
                }
                result[i] = prod;
            }
        }
        return result;
    }
}
