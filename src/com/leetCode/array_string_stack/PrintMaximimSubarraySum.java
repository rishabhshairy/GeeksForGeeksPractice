package com.leetCode.array_string_stack;

public class PrintMaximimSubarraySum {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubarraySum(arr, arr.length);
    }

    /**
     * Here we are storing index to print any subArray
     *
     * @param arr
     * @param n
     * @return
     */
    public static long maxSubarraySum(int[] arr, int n) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0; // this points to staring index when sum cross maxSum

        int ansStart = -1, ansEnd = -1;

        for (int i = 0; i < n; i++) {

            // this is preventive check because we are not considering sub-array where sum is 0
            if (sum == 0) {
                start = i;
            }

            sum += arr[i];
            if (sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }

        // print sub array
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }

        return maxSum;
    }
}
