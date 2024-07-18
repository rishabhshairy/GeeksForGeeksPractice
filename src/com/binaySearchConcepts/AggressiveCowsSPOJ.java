package com.binaySearchConcepts;

import java.util.Arrays;

/**
 * https://www.naukri.com/code360/problems/aggressive-cows_1082559
 */
public class AggressiveCowsSPOJ {
    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int cows = 4;
        System.out.println(aggressiveCowsBruteForce(stalls, cows));
    }

    /**
     * This is binary search approach
     *
     * @param stalls
     * @param cows
     * @return
     */
    public static int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            if (!isPossibleToPlace(stalls, mid, cows)) {
                // if not possible at mid, move to the left half
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // always high will be the answer because it goes to opposite polarity and exhausts

        return high;
    }

    /**
     * This is brute force approach where we go from 1 to (max-min) of array
     *
     * @param stalls
     * @param k
     * @return
     */
    public static int aggressiveCowsBruteForce(int[] stalls, int cows) {
        //    Write your code here.
        Arrays.sort(stalls);

        int limit = stalls[stalls.length - 1] - stalls[0];

        int maxDistance = Integer.MIN_VALUE;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < stalls.length; i++) {
            maxDistance = Math.max(maxDistance, stalls[i]);
            minDistance = Math.min(minDistance, stalls[i]);
        }

        for (int i = 1; i <= (maxDistance - minDistance); i++) {
            if (!isPossibleToPlace(stalls, i, cows)) {
                return i - 1;
            }
        }
        return limit;
    }

    private static boolean isPossibleToPlace(int[] stalls, int distance, int totalCows) {
        int currCowPlaced = 1;
        int currCowPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - currCowPosition >= distance) {
                currCowPlaced++;
                currCowPosition = stalls[i];
            }
        }

        return currCowPlaced >= totalCows;
    }
}
