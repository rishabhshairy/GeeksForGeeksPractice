package com.slidingwindow.hard;

public class MinOperationsToReduceXtoZero {
    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;
        new MinOperationsToReduceXtoZero().minOperations(nums, x);
    }

    /**
     * Approach
     * <p>
     * find total sum of array
     * our target is to find sum-x of min sub array
     *
     * @param nums
     * @param x
     * @return
     */
    public int minOperations(int[] nums, int x) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int target = sum - x;

        int minLength = 0;

        if (target < 0) {
            return -1;
        }
        if (target == 0) {
            return nums.length;
        }

        int left = 0, right = 0;
        while (right < nums.length) {

            target -= nums[right];

            while (target < 0) {
                target += nums[left];
                System.out.println("Add=" + target);
                left++;
            }

            if (target == 0) {
                minLength = Math.max(minLength, right - left + 1);
            }

            right++;
        }

        return minLength == 0 ? -1 : minLength;
    }
}
