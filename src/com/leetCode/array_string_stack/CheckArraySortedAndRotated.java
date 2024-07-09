package com.leetCode.array_string_stack;

/**
 *  https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
 * Given an array nums, return true if the array was originally sorted in non-decreasing order,
 * then rotated some number of positions (including zero). Otherwise, return false.
 *
 * There may be duplicates in the original array.
 *
 * Note: An array A rotated by x positions results in an array B of the same length
 * such that A[i] == B[(i+x) % A.length], where % is the modulo operation.
 */
public class CheckArraySortedAndRotated {
    public static void main(String[] args) {
        CheckArraySortedAndRotated obj = new CheckArraySortedAndRotated();
        int[] nums = {3, 4, 5, 1, 2, 6};
        System.out.println(obj.check(nums));
    }

    public boolean check(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                count++;
            }
        }
        if (count > 1) {
            return false;
        }
        return true;
    }
}
