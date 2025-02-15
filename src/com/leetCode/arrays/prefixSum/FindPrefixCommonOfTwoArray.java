package com.leetCode.arrays.prefixSum;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * lC 2657
 */
public class FindPrefixCommonOfTwoArray {

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4};
        int[] B = {3, 1, 2, 4};
        findThePrefixCommonArray(A, B);
    }

    public int[] findThePrefixCommonArrayBrute(int[] a, int[] b) {
        Set<Integer> numA = new LinkedHashSet<>();
        Set<Integer> numB = new LinkedHashSet<>();

        int[] result = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            int count = 0;
            numA.add(a[i]);
            numB.add(b[i]);

            for (int e : numA) {
                if (numB.contains(e)) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;

    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[50];
        int[] result = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            int valA = A[i];
            int valB = B[i];
            freq[valA]++;
            if (freq[valA] == 2) {
                count++;
            }
            freq[valB]++;
            if (freq[valB] == 2) {
                count++;
            }
            result[i]=count;
        }
        return result;
    }
}
