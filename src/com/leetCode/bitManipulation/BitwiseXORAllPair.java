package com.leetCode.bitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 2425
 */
public class BitwiseXORAllPair {

    /**
     * Approach
     * num1 odd and num2 even --> all Elements of num1 will cancel each other in num3[pair]
     * num2 odd and num1 even --> all elements of num2 will cancel each other in num3
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int xorAllNumsOptimal(int[] nums1, int[] nums2) {
        int res = 0;

        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 % 2 != 0) {
            for (int i = 0; i < n2; i++) {
                res ^= nums2[i];
            }
        }

        if (n2 % 2 != 0) {
            for (int i = 0; i < n1; i++) {
                res ^= nums1[i];
            }
        }
        return res;
    }

    /**
     * Brute force
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int xorAllNums(int[] nums1, int[] nums2) {
        List<Integer> xorPairs = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                xorPairs.add(nums1[i] ^ nums2[j]);
            }
        }
        int res = xorPairs.get(0);
        for (int i = 1; i < xorPairs.size(); i++) {
            res = res ^ xorPairs.get(i);
        }

        return res;
    }
}
