package com.leetCode.arrays.binarySearch;

import java.util.Stack;

/**
 * LC 456
 */
public class Q132Pattern {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

    }

    /**
     * Approach next greater
     * next smaller
     *
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        int k = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < k) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                k = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

}
