package com.leetCode.binarySearch;

import java.util.Arrays;

public class FairCandySwap {
    public static void main(String[] args) {
        int[] a = {1, 1};
        int[] b = {2, 2};
        fairCandySwap(a, b);
    }


    /**
     * Binary Search
     *
     * @param aliceSizes
     * @param bobSizes
     * @return
     */
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        Arrays.sort(bobSizes);
        int n = aliceSizes.length;
        int m = bobSizes.length;

        int aliceTotal = 0;
        int bobTotal = 0;
        for (int candy :
                aliceSizes) {
            aliceTotal += candy;
        }

        for (int candy :
                bobSizes) {
            bobTotal += candy;
        }
        for (int i = 0; i < n; i++) {
            int target = (bobTotal - aliceTotal + (2 * aliceSizes[i])) / 2;
            if (findTargetInBob(bobSizes, target)) {
                return new int[]{aliceSizes[i], target};
            }
        }
        return new int[0];
    }

    private static boolean findTargetInBob(int[] bobSizes, int target) {
        int low = 0;
        int high = bobSizes.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (bobSizes[mid] == target) {
                return true;
            } else if (bobSizes[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    /**
     * Brute force
     *
     * @param aliceSizes
     * @param bobSizes
     * @return
     */
    public static int[] fairCandySwapBruteForce(int[] aliceSizes, int[] bobSizes) {
        int n = aliceSizes.length;
        int m = bobSizes.length;

        int aliceTotal = 0;
        int bobTotal = 0;
        for (int candy :
                aliceSizes) {
            aliceTotal += candy;
        }

        for (int candy :
                bobSizes) {
            bobTotal += candy;
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                int x = aliceTotal - aliceSizes[i] + bobSizes[j];
                int y = bobTotal - bobSizes[j] + aliceSizes[i];
                if (x == y) {
                    return new int[]{aliceSizes[i], bobSizes[j]};


                }
            }
        }
        return new int[0];
    }
}
