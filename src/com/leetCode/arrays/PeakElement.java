package com.leetCode.arrays;

public class PeakElement {
    public static void main(String[] args) {
        int[] test = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(test));

    }

    static int findPeakElement(int[] nums) {
        int peekIndex = 0;
        int n = nums.length;
        int min = Integer.MIN_VALUE;
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return nums[1] > nums[0] ? 1 : 0;
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] > min && nums[i] > nums[i + 1]) {

                    peekIndex = i;
                }
            } else if (i == n - 1) {
                if (nums[i] > nums[i - 1] && nums[i] > min) {

                    peekIndex = i;
                }
            } else if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peekIndex = i;
            }
        }
        return peekIndex;
    }

    static int findPeakElementBinarySearch(int[] nums) {
        // Do manual check to reduce search space
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        // start binary search now
        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Direct check if mid is peak
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            // now do the elimination of search space
            if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } else if (nums[mid] > nums[mid + 1]) {
                high = mid - 1;
            } else {
                // this is extra check for multiple peak
                // we can go either left or right
                low = mid + 1;
            }

        }
        return -1;
    }
}
