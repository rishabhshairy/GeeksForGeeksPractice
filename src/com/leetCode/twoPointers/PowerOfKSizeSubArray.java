package com.leetCode.twoPointers;

import java.util.Arrays;

public class PowerOfKSizeSubArray {
    public static void main(String[] args) {
        int[] nums = {1, 30, 31, 32};
        int k = 3;
        int[] resultsArray = resultsArray(nums, k);
        for (int i = 0; i < resultsArray.length; i++) {
            System.out.print(resultsArray[i] + " ");
        }
    }

    /**
     * Two Pointer Approach
     *
     * @param nums
     * @param k
     * @return
     */
    private static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        Arrays.fill(res, -1);

        int count = 1;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] + 1 == nums[i]) {
                count++;
            } else {
                count = 1;
            }

            // now check if we reach k with count
            if (count >= k) {
                res[i - k + 1] = nums[i];
            }
        }

        return res;
    }

    public static int[] resultsArrayBruteForce(int[] nums, int k) {
        if (nums.length == 1 || k == 1) {
            return nums;
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resIndex = 0;
        boolean isCons = false;

        for (int i = 0; i <= nums.length - k; i++) {
            int j = i;
            for (; j < i + k - 1; j++) {
                if (nums[j] + 1 == nums[j + 1]) {
                    isCons = true;
                } else {
                    isCons = false;

                }
            }
            if (isCons) {
                result[resIndex++] = nums[j];
            } else {
                result[resIndex++] = -1;
            }
        }
        return result;
    }
}
