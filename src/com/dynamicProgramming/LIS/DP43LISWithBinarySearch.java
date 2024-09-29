package com.dynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DP43LISWithBinarySearch {
    public static void main(String[] args) {
        int[] arr = {5, 4, 11, 1, 16, 8};
    }

    public static int longestIncreasingSubsequence(int arr[]) {
        //Your code goes here
        List<Integer> result = new ArrayList<>();
        int len = 1;
        result.add(arr[0]);

        for (int index = 1; index < arr.length; index++) {
            if (arr[index] > result.get(result.size() - 1)) {
                result.add(arr[index]);
                len++;
            } else {
                // do lower bound on arr
                int ind = Collections.binarySearch(result, arr[index]);
                if (ind < 0) {
                    ind = -ind - 1;
                }
                result.set(ind,arr[index]);
            }
        }
        return len;
    }
}
