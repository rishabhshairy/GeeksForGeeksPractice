package com.dynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class DP46LongestBitonicSequecne {
    public static void main(String[] args) {
//        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        int[] arr = {5, 7, 9};
        System.out.println(longestBitonicSequence(arr, arr.length));
    }


    /**
     * Using concept of Dp41 and DP42
     * Directly using the optimised way of tabulation
     *
     * @param arr
     * @param n
     * @return
     */
    public static int longestBitonicSequence(int[] arr, int n) {
        int[] dpFront = new int[n];
        int[] dpBack = new int[n];
        int[] bitonic = new int[n];

        for (int i = 0; i < n; i++) {
            dpFront[i] = 1;
            dpBack[i] = 1;
        }


        for (int index = 0; index < n; index++) {
            for (int prevIndex = 0; prevIndex < index; prevIndex++) {
                if (arr[prevIndex] < arr[index]) {
                    dpFront[index] = Math.max(dpFront[index], 1 + dpFront[prevIndex]);
                }
            }

        }


        for (int index = n - 1; index >= 0; index--) {
            for (int prevIndex = n - 1; prevIndex > index; prevIndex--) {
                if (arr[prevIndex] < arr[index]) {
                    dpBack[index] = Math.max(dpBack[index], 1 + dpBack[prevIndex]);
                }
            }
        }
        int maxi = 0;

//        for (int index = 0; index < n; index++) {
//            maxi = Math.max(maxi, dpFront[index] + dpBack[index] - 1);
//        }

        // GFG Check only for bitonic , not only increasing and decreasing
        for (int index = 0; index < n; index++) {
            if (dpFront[index] > 1 && dpBack[index] > 1) {
                maxi = Math.max(maxi, dpFront[index] + dpBack[index] - 1);
            }
        }

        return maxi;
    }
}
