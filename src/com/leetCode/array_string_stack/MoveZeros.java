package com.leetCode.array_string_stack;

/**
 * https://leetcode.com/problems/move-zeroes/description/
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeros {
    public static void main(String[] args) {
        MoveZeros obj = new MoveZeros();
        int[] arr = new int[]{0, 1, 0, 3, 1, 2};
        obj.moveZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void moveZeroes(int[] nums) {
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
    }
}
