package com.leetCode.binarySearch;

/**
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
 */
public class FindSmallestDivisor {
    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[]{1, 2, 5, 9}, 6));
    }

    /**
     * Using binary Search Approach
     *
     * @param nums
     * @param threshold
     * @return
     */
    public static int smallestDivisor(int[] nums, int threshold) {

        //  If the minimum summation i.e. n > threshold value, the answer does not exist. In this case, we will return -1.
        if (nums.length > threshold) {
            return -1;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        // Now apply binary search
        int low = 1;
        int high = max;
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isDivisorSumLess(nums, mid, threshold)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isDivisorSumLess(int[] nums, int mid, int threshold) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.ceil((double) nums[i] / (double) mid);
        }
        return sum <= threshold;
    }
}
