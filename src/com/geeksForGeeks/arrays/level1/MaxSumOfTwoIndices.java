package com.geeksForGeeks.arrays.level1;

/** GFG --> https://www.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/0
 * Given an array arr[], with index ranging from 0 to n-1, select any two indexes, i and j such that i < j .
 * From the subarray arr[i...j], select the two minimum numbers and add them, you will get the score for that subarray.
 * Return the maximum possible score across all the subarrays of array arr[].
 */
public class MaxSumOfTwoIndices {
    public static void main(String[] args) {

    }

    public static long pairWithMaxSum(long nums[], long N) {
        // Your code goes here
        long maxSum = Integer.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sum = nums[i] + nums[i + 1];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
