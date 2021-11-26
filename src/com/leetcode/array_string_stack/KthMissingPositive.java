package com.leetcode.array_string_stack;

import java.util.ArrayList;

public class KthMissingPositive {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        KthMissingPositive missingPositive = new KthMissingPositive();
        missingPositive.findKthPositive(arr, 2);
    }

    public int findKthPositive(int[] arr, int k) {
        for (int num :
                arr) {
            if (num <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }
}
