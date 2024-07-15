package com.leetCode.array_string_stack;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
 */
public class SearchInRotatedAndSorted2 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 1, 2, 3, 3, 3, 3, 3}, 4));
    }

    public static boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return true;
            }
            // reduce search space by checking below condition
            // this is special condition for duplicate elements
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // left sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // checking for right sorted
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

}
