package com.leetCode.arrays.hashing;

import java.util.Arrays;

public class FindHIndex {
    public static void main(String[] args) {
//        int[] arr = {5, 1, 2, 8, 9, 3};
        int[] arr = {3, 0, 6, 1, 5};
        FindHIndex obj = new FindHIndex();
        obj.hIndex(arr);
    }

    private int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];

        for (int citation : citations) {
            papers[Math.min(citation, n)]++;
        }

        // finding H-Index
        int h = n;
        int s = papers[n];
        while (h > s) {
            h--;
            s += papers[h];
        }
        return h;
    }

    /**
     * Brute Force
     *
     * @param citations
     * @return
     */
    public int hIndexBrute(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i) {
                return citations.length - i;
            }
        }
        return 0;
    }
}
