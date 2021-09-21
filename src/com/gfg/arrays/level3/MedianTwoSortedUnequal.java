package com.gfg.arrays.level3;

public class MedianTwoSortedUnequal {
    public static void main(String[] args) {
        int[] ar1 = {-5, 3, 6, 12, 15};
        int[] ar2 = {-12, -10, -6, -3, 4, 10};
        int n = ar1.length;
        int m = ar2.length;
    }

    static double getMedian(int[] a, int n, int[] b, int m) {
        // TODO: Solve with Clear Mind with all approach
        double m1 = -1, m2 = -1;
        int i = 0, j = 0, count = 0;

        if ((m + n) % 2 != 0) {
            for (count = 0; count <= (m + n) / 2; count++) {
                if (i != n && j != m) {
                    m1 = (a[i] > b[j]) ? b[j++] : a[i++];
                } else if (i < n) {
                    m1 = a[i++];
                } else {
                    m1 = b[j++];
                }
            }
            return m1;
        } else {
            for (count = 0; count <= (n + m) / 2; count++) {
                m2 = m1;
                if (i != n && j != m) {
                    m1 = (a[i] > b[j]) ? b[j++] : a[i++];
                } else if (i < n) {
                    m1 = a[i++];
                } else {
                    m1 = b[j++];
                }
            }
            return (m1 + m2) / 2;
        }
    }
}
