package com.leetCode.array_string_stack;

public class FindMinimumInRotatedSorted {
    public static void main(String[] args) {

    }

    public int findMinBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                return nums[i+1];
            }
        }
        return Integer.MIN_VALUE;
    }

    /**
     * This is using binary search to find answer
     * @param arr
     * @return
     */
    public int findMin(int[] arr) {
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // if left half is sorted
            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            } else {
                // if right half is sorted
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}
