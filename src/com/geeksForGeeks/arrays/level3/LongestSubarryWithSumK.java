package com.geeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarryWithSumK {
    public static void main(String[] args) {
        int arr[] = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println(solutionBruteForce(arr, arr.length, k));
        System.out.println(solutionOn2(arr, arr.length, k));
        System.out.println(hashingApproach(arr, arr.length, k));

    }

    /**
     * TC --> O(n^3)
     *
     * @param arr
     * @param n
     * @param k
     * @return
     */
    public static int solutionBruteForce(int[] arr, int n, int k) {
        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += arr[l];
                }

                if (sum == k) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }

    /**
     * Here we are considering index i as staring index and j as ending index
     * j will run from i -> n-1
     *
     * @param arr
     * @param n
     * @param k
     * @return
     */
    public static int solutionOn2(int[] arr, int n, int k) {
        int len = 0;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    len = Math.max(len, j - i + 1);
                }
            }

        }
        return len;
    }

    /**
     * This also works only for positive integers
     *
     * @param arr
     * @param n
     * @param k
     * @return
     */
    public static int hashingApproach(int[] arr, int n, int k) {
        Map<Long, Integer> preSumMap = new HashMap<>();
        int len = 0;
        long prefixSum = 0;

        for (int i = 0; i < n; i++) {
            // calculate prefix sum
            prefixSum += arr[i];

            if (prefixSum == k) {
                len = Math.max(len, i + 1);
            }

            long rem = prefixSum - k;

            // check if rem exists in map i.e prefixSum exists
            // recalculate length
            if (preSumMap.containsKey(rem)) {
                int currLength = i - preSumMap.get(rem);
                len = Math.max(len, currLength);
            }

            if (!preSumMap.containsKey(prefixSum)) {
                preSumMap.put(prefixSum, i);
            }
        }
        return len;
    }

}

