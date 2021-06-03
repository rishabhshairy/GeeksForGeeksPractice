package com.gfg.arrays.level3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ChoclateDistribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            ArrayList<Long> arr = new ArrayList<Long>();
            for (int i = 0; i < n; i++) {
                long x = sc.nextInt();
                arr.add(x);
            }
            long m = sc.nextLong();

            System.out.println(findMinDiff(arr, n, m));
        }
    }

    private static long findMinDiff(ArrayList<Long> a, long n, long m) {
        Collections.sort(a);
        long minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < a.size()-m; i++) {
            int l = i;
            int r = l + (int) m - 1;
            minDiff = Math.min(minDiff, a.get(r) - a.get(l));
        }
        return minDiff;
    }


}
