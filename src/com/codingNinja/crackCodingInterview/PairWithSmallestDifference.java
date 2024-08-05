package com.codingNinja.crackCodingInterview;

import java.util.ArrayList;
import java.util.Collections;

public class PairWithSmallestDifference {
    public static void main(String[] args) {

    }

    public static int smallestDifferencePair(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m) {
        // Write your code here
        Collections.sort(arr1);
        Collections.sort(arr2);
        int mini = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i).equals(arr2.get(j))) {
                i++;
                j++;
                mini = 0;
            } else if (arr1.get(i) < arr2.get(j)) {
                mini = Math.min(mini, Math.abs(arr1.get(i) - arr2.get(j)));
                i++;
            } else {
                mini = Math.min(mini, Math.abs(arr1.get(i) - arr2.get(j)));
                j++;
            }
        }
        return mini;
    }
}
