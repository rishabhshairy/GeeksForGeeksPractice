package com.leetCode.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NandDoubleExists {
    public static void main(String[] args) {
        int[] arr = {10, 2, 5, 3};
        NandDoubleExists obj = new NandDoubleExists();
        System.out.println(obj.checkIfExist(arr));
    }

    /**
     * Sort the array arr in ascending order to enable efficient searching.
     * <p>
     * For each element arr[i] in the array:
     * <p>
     * Calculate the target value as 2 * arr[i] (double the current number).
     * Perform a custom binary search for the target in the array:
     * In the customBinarySearch function:
     * Set left to 0 and right to arr.length - 1 to define the search range.
     * While left <= right, calculate the midpoint mid.
     * If arr[mid] == target, return the index mid (target found).
     * If arr[mid] < target, move the left pointer to mid + 1 to search the right half.
     * If arr[mid] > target, move the right pointer to mid - 1 to search the left half.
     * If the target is not found, return -1.
     * If the target exists and its index is not the same as the current index i,
     * return true (found a pair where one element is double the other).
     * If no valid pair is found after iterating through the array, return false.
     *
     * @param arr
     * @return
     */
    private boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int target = 2 * arr[i];
            int index = doBinarySearch(arr, target);

            if (index >= 0 && index != i) {
                return true;
            }
        }

        return false;
    }

    private int doBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Set Approach
     *
     * @param arr
     * @return
     */
    public boolean checkIfExistUsingSet(int[] arr) {
        Set<Integer> numSet = new HashSet<>();

        for (int num : arr) {
            if (numSet.contains(2 * num) || (num % 2 == 0 && numSet.contains(num / 2))) {
                return true;
            }
            numSet.add(num);
        }
        return false;
    }
}
