package com.binaySearchConcepts;

/**
 * You are given a sorted array 'arr' of distinct values and a target value 'm'.
 * You need to search for the index of the target value in the array.
 * <p>
 * 1. If the value is present in the array, return its index.
 * 2. If the value is absent, determine the index where it would be inserted in the array while maintaining the sorted order.
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] arr, int target) {
        // Write your code here.
        int ans = arr.length;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
