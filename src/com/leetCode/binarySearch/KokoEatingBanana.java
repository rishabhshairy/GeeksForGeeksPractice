package com.leetCode.binarySearch;

/**
 * https://leetcode.com/problems/koko-eating-bananas/description/
 */
public class KokoEatingBanana {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{805306368,805306368,805306368}, 1000000000));
    }

    public static int minEatingSpeed(int[] piles, int hours) {
        int low = 1;
        int high = maxPiles(piles);
        int ans = 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int totalHours = findTotalHours(piles, mid);
            System.out.println(totalHours);
            if (totalHours <= hours && totalHours > 0) { // add condition totalHours > 0 to check for overflow
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int findTotalHours(int[] piles, int hourly) {
        int totalHours = 0;
        // find total hours to eat whole pile if eating hourly banana per hour
        for (int i = 0; i < piles.length; i++) {
            totalHours += (int) Math.ceil((double) piles[i] / (double) hourly);
        }
        return totalHours;
    }

    private static int maxPiles(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }
}
