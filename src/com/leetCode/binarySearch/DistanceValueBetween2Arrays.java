package com.leetCode.binarySearch;

import java.util.Arrays;

/**
 * LC -- 1385
 */
public class DistanceValueBetween2Arrays {
    public static void main(String[] args) {
        int[] arr1 = {4, 5, 8};
        int[] arr2 = {10, 9, 1, 8};
        int d = 2;

        System.out.println(findTheDistanceValue(arr1, arr2, d));
    }

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            count++;
            int low = 0;
            int high = arr2.length - 1;

            int rangeFrom = arr1[i] - d;
            int rangeTo = arr1[i] + d;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (rangeFrom <= arr2[mid] && arr2[mid] <= rangeTo) {
                    count--;
                    break;
                } else if (arr2[mid] > rangeFrom) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return count;
    }

    /**
     * This is brute force
     *
     * @param arr1
     * @param arr2
     * @param d
     * @return
     */
    public static int findTheDistanceValueBruteForce(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            count++;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}
