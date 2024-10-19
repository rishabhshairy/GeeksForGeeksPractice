package com.slidingwindow;

/**
 * LC 1343 --> https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/
 * Given an array of integers arr and two integers k and threshold,
 * return the number of sub-arrays of size k and average greater than or equal to threshold.
 */
public class CountOfSubArrOfSizeKAvg {
    public static void main(String[] args) {
        int[] arr = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        int k = 3;
        int threshold = 5;
        System.out.println("Ans::" + numOfSubarrays(arr, k, threshold));
    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0, right = 0, sum = 0;
        int avg = 0, count = 0;

        while (right < arr.length) {
            sum += arr[right];
            int currWindow = right - left + 1;

            if (currWindow < k) {
                right++;
            } else if (currWindow == k) {
                avg = sum / k;
                if (avg >= threshold) {
                    count++;
                }
                sum -= arr[left];
                left++;
                right++;
            }

        }
        return count;
    }
}
