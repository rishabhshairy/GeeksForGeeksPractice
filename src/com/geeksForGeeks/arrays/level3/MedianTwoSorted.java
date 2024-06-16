package com.geeksForGeeks.arrays.level3;

public class MedianTwoSorted {
    public static void main(String[] args) {
        int ar1[] = {1, 2, 3, 6};
        int ar2[] = {4, 6, 8, 10};
        int n1 = ar1.length;
        int n2 = ar2.length;
        System.out.println(getMedian(ar1, 0, n1 - 1, ar2, 0, n2 - 1));
    }

    static int getMedian(int[] a, int sA, int eA, int[] b, int sB, int eB) {
        if (eA - sA == 1) {
            return (Math.max(a[sA], b[sB]) + Math.min(a[eA], b[eB])) / 2;
        }

        int medA = median(a, sA, eA);
        int medB = median(b, sB, eB);

        if (medA == medB) {
            return medA;
        }

        if (medA > medB) {
            return getMedian(a, sA, (sA + eA + 1) / 2, b, (sB + eB + 1) / 2, eB);
        } else {
            return getMedian(a, (sA + eA + 1) / 2, eA, b, sB, (sB + eB + 1) / 2);
        }
    }

    static int median(int[] a, int left, int right) {
        int length = right - left + 1;
        if (length % 2 != 0) {
            return a[left + length / 2];
        }
        return (a[left + (length / 2 - 1)] + a[left + length / 2]) / 2;
    }
}
