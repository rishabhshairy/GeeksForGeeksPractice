package com.geeksForGeeks.arrays.level3;

import java.util.Arrays;
import java.util.Scanner;

public class CountInversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int) n];

            for (long i = 0; i < n; i++)
                arr[(int) i] = sc.nextLong();

            System.out.println(inversionCount(arr, n));

        }
    }

    private static int inversionCount(long[] arr, long n) {
        return mergeAndSortCount(arr, 0, n - 1);

    }

    static int mergeCount(long[] arr, long l, long m, long r) {
        long[] left = Arrays.copyOfRange(arr, (int) l, (int) m + 1);
        long[] right = Arrays.copyOfRange(arr, (int) m + 1, (int) r + 1);

        // split into two halves

        int i = 0, j = 0, k = (int) l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];

        return swaps;
    }

    static int mergeAndSortCount(long[] arr, long l, long r) {
        int invCount = 0;
        if (l < r) {

            long m = (l + r) / 2;
            invCount += mergeAndSortCount(arr, l, m);
            invCount += mergeAndSortCount(arr, m + 1, r);

            invCount += mergeCount(arr, l, m, r);
        }
        return invCount;
    }


}
