package com.leetCode.arrays.twoPointer;

/**
 * LC 26
 */
public class RemoveDuplicates1 {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicates(arr);
    }

    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] < nums[right]) {
                left++;
                nums[left] = nums[right];
            }
            right++;

        }
        return left + 1;
    }
}
