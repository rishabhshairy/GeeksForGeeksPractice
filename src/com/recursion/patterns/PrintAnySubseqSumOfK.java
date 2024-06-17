package com.recursion.patterns;

import java.util.Stack;

/**
 * Note :: this can also be framed as if array contains any subsequence whose sum is K
 */
public class PrintAnySubseqSumOfK {
    public static void main(String[] args) {
        int sum = 7;
        int[] arr = {1, 3, 4, 6, 2, 5};
        printAnySubsequenceOfSumK(0, new Stack<Integer>(), 0, sum, arr, arr.length);
    }

    /**
     * @param i
     * @param nums
     * @param s
     * @param sum
     * @param arr
     * @param length
     * @return boolean
     */
    private static boolean printAnySubsequenceOfSumK(int i, Stack<Integer> nums, int s, int sum, int[] arr, int length) {
        if (i == length) {
            if (s == sum) {
                System.out.println(nums);
                return true;
            }
            return false;
        }

        // pick the index
        nums.push(arr[i]);
        s += arr[i];
        if (printAnySubsequenceOfSumK(i + 1, nums, s, sum, arr, length)) {
            return true;
        }
        // do  not pick the index
        nums.pop();
        s -= arr[i];
        if (printAnySubsequenceOfSumK(i + 1, nums, s, sum, arr, length)) {
            return true;
        }

        return false;
    }

}
