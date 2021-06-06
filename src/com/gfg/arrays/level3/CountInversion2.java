package com.gfg.arrays.level3;

import java.util.Arrays;

public class CountInversion2 {
    static long merge(long[] a, long[] aux, long lb, long mid, long ub) {
        long c = 0;
        int i = (int) lb;
        int j = (int) mid + 1;
        int k = (int) lb;
        while (i <= mid && j <= ub) {
            if (a[i] <= a[j]) {
                aux[k++] = a[i++];
            } else {
                aux[k++] = a[j++];
                c += (mid - i + 1);
            }
        }
        while (i <= mid) {
            aux[k++] = a[i++];
        }
        for (i = (int) lb; i <= (int) ub; i++) {
            a[i] = aux[i];
        }
        return c;
    }

    static long mergeSort(long[] a, long aux[], long lb, long ub) {
        long c = 0;
        if (ub == lb) {
            return 0;
        }
        long mid = (lb + ((ub - lb) >> 1));
        c += mergeSort(a, aux, lb, mid);
        c += mergeSort(a, aux, mid + 1, ub);
        c += merge(a, aux, lb, mid, ub);
        return c;
    }

    static long inversionCount(long arr[], long N) {
// Your Code Here
        if (N == 1 || N == 0) return 0;
        long[] aux = Arrays.copyOf(arr, (int) N);
        return mergeSort(arr, aux, 0, N - 1);
    }
}
