package com.leetCode.arrays.twoPointer;

public class ApplyOperation {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = 2 * nums[i];
                nums[i + 1] = 0;
            }
        }
        int zeros = 0;
        int p2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                nums[p2++] = nums[i];
            }
        }
        // fill zeros at end
        for (int i = 0; i < zeros; i++) {
            nums[p2++] = 0;
        }
        return nums;
    }
}
