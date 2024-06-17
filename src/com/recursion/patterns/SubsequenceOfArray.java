package com.recursion.patterns;

import java.util.Stack;

/**
 * Time complexity is 2powerN * N
 */
public class SubsequenceOfArray {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 5};
        subsequence(0, new Stack<>(), arr.length, arr);
    }

    /**
     * @param i
     * @param nums
     * @param n
     * @param arr
     */
    public static void subsequence(int i, Stack<Integer> nums, int n, int[] arr) {
        if (i >= n) {
            System.out.println(nums);
            return;
        }

        // take or pick the particular index into subsequence
        nums.push(arr[i]);
        subsequence(i + 1, nums, n, arr);
        // not pick the particular index into subsequence
        nums.pop();
        subsequence(i + 1, nums, n, arr);
    }
}
