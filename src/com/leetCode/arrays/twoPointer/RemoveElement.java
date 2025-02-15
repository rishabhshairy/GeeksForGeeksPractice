package com.leetCode.arrays.twoPointer;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int last = 0;
        int first = 0;

        while (first < nums.length) {
            if (nums[first] != val) {
                nums[last] = nums[first];
                last++;
            }
            first++;
        }
        return last;
    }
}
