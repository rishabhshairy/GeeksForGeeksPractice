package com.recursion.patterns;

import java.util.Stack;

public class SubsequenceOfSumK {
    public static void main(String[] args) {
        int sum = 7;
        int[] arr = {1, 3, 4, 6, 2, 5};
        printSubsequenceOfSumK(0, new Stack<Integer>(), 0, sum, arr, arr.length);
    }

    /**
     * @param i
     * @param nums
     * @param s
     * @param sum
     * @param arr
     * @param length
     */
    private static void printSubsequenceOfSumK(int i, Stack<Integer> nums, int s, int sum, int[] arr, int length) {
        if (i >= length) {
            if (s == sum) {
                System.out.println(nums);
            }
            return;
        }
        // pick the index
        nums.push(arr[i]);
        s += arr[i];
        printSubsequenceOfSumK(i + 1, nums, s, sum, arr, length);
        // do  not pick the index
        nums.pop();
        s -= arr[i];
        printSubsequenceOfSumK(i + 1, nums, s, sum, arr, length);

    }
}
