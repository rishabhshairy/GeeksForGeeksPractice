package com.leetCode.arrays.prefixSum;

import java.util.Arrays;

public class WaysToSplitArray {
    public static void main(String[] args) {
//        int[] arr = {10, 4, -8, 7};
        int[] arr = {3, 2};
        WaysToSplitArray obj = new WaysToSplitArray();
        obj.waysToSplitArray(arr);
    }

    private int waysToSplitArray(int[] arr) {
        long sum = 0;

        for (int num : arr) {
            sum += num;
        }

        int result = 0;
        long runningSum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            runningSum += arr[i];

            long remainingSum = sum - runningSum;

            if (runningSum >= remainingSum) {
                result++;
            }
        }
        return result;
    }


    /**
     * TC -- O(n)
     * SC --> O(n)
     *
     * @param nums
     * @return
     */
    public int waysToSplitArrayExtraSpace(int[] nums) {
        int result = 0;
        int n = nums.length;
        long[] prefixFwdSum = new long[n];
        long[] prefixBackSum = new long[n];

        prefixFwdSum[0] = nums[0];
        prefixBackSum[n - 1] = nums[n - 1];

        for (int i = 1; i < n - 1; i++) {
            prefixFwdSum[i] = nums[i] + prefixFwdSum[i - 1];
        }

        for (int i = n - 2; i > 0; i--) {
            prefixBackSum[i] = nums[i] + prefixBackSum[i + 1];
        }

//        for (int num :
//                prefixFwdSum) {
//            System.out.print(num + " ");
//        }
//        System.out.print("\n");
//        for (int num :
//                prefixBackSum) {
//            System.out.print(num + " ");
//        }
//        System.out.print("\n");
        for (int i = 0; i < n - 1; i++) {
            if (prefixFwdSum[i] >= prefixBackSum[i + 1]) {
                result++;
            }
        }
        System.out.print(result);
        return result;
    }
}
