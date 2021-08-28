package com.leetcode.binarySearch;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int target = 2;
        System.out.println(searchInsert(arr, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pos = 0;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                pos = mid;
                break;
            }
            if (nums[mid] > target) {
                right = mid - 1;
                pos = left;
            } else {
                left = mid + 1;
                pos = left;
            }
        }

        return pos;
    }
}
