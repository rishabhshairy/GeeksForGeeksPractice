package com.leetCode.arrays.twoPointer;

public class RemoveDuplicateFromSorted2 {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        int left = 2;
        for (int right = 2; right < nums.length; right++) {
            if (nums[right] != nums[left - 2]) {
                nums[right] = nums[left++];
            }
        }
        return left;
    }
}
