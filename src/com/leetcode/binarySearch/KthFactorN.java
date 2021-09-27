package com.leetcode.binarySearch;

import java.util.ArrayList;

public class KthFactorN {
    public static void main(String[] args) {
        int n = 1000;
        int k = 4;

    }

    public int kthFactor(int n, int k) {
//        ArrayList<Integer> factors = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            if (n % i == 0) {
//                factors.add(i);
//            }
//        }
//        return k > factors.size() ? -1 : factors.get(k - 1);

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if ((n & i) == 0) {
                count++;
            }
            if (count == k) {
                return i;
            }
        }
        return -1;
    }
}
