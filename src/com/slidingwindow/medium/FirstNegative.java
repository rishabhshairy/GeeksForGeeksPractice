package com.slidingwindow.medium;

import java.util.ArrayList;

/**
 * GFG
 * Given an array A[] of size N and a positive integer K,
 * find the first negative integer for each and every window(contiguous subarray) of size K.
 */
public class FirstNegative {

    public static void main(String[] args) {
//        long[] arr = {-8, 2, 3, -6, 10};
        long[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        long[] negativeInteger = printFirstNegativeInteger(arr, arr.length, 3);
        for (long num :
                negativeInteger) {
            System.out.println(num);
        }
    }

    public static long[] printFirstNegativeInteger(long[] arr, int n, int k) {
        ArrayList<Long> negativeList = new ArrayList<>();
        int left = 0;
        int right = 0;

        while (right < n) {
            if (right - left + 1 == k) {
                // logic
                int windowSize = right - left + 1;
                boolean isNegativePresent = false;

                for (int i = left; i <= right; i++) {
                    if (arr[i] < 0) {
                        negativeList.add(arr[i]);
                        isNegativePresent = true;
                        break;
                    }
                }
                if (!isNegativePresent) {
                    negativeList.add(0L);
                }

                left++;
                right++;
            }

            if (right - left + 1 < k) {
                right++;
            }
        }

        long[] ans = new long[negativeList.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = negativeList.get(i);
        }

        return ans;
    }
}
