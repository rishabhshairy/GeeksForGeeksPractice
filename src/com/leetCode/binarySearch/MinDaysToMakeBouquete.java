package com.leetCode.binarySearch;

/**
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
 */
public class MinDaysToMakeBouquete {
    public static void main(String[] args) {
        int[] bloomDays = {1, 2, 1, 2, 7, 2, 2, 3, 1};
        int m = 2;
        int k = 3;
        System.out.println(minDaysBruteForce(bloomDays, m, k));
        System.out.println(minDays(bloomDays, m, k));
    }

    /**
     * This is optimal approach using Binary Search
     *
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    public static int minDays(int[] bloomDay, int m, int k) {
        int noOfFlowers = bloomDay.length;

        long requiredFlowers = (long) m * k;

        if (requiredFlowers > noOfFlowers) {
            return -1;
        }

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            minDay = Math.min(minDay, bloomDay[i]);
            maxDay = Math.max(maxDay, bloomDay[i]);
        }

        int low = minDay;
        int high = maxDay;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * This is a brute force approach
     *
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    public static int minDaysBruteForce(int[] bloomDay, int m, int k) {
        int noOfFlowers = bloomDay.length;

        long requiredFlowers = (long) m * k;

        if (requiredFlowers > noOfFlowers) {
            return -1;
        }

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            minDay = Math.min(minDay, bloomDay[i]);
            maxDay = Math.max(maxDay, bloomDay[i]);
        }

        // now check for each bloom day if its possible to form bouquet

        for (int i = minDay; i <= maxDay; i++) {
            if (isPossible(bloomDay, i, m, k)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isPossible(int[] bloomDay, int day, int m, int k) {
        int counter = 0;
        int bouquets = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                counter++;
            } else {
                bouquets += counter / k;
                counter = 0;
            }
        }
        bouquets += (counter / k);
        return bouquets >= m;
    }
}
