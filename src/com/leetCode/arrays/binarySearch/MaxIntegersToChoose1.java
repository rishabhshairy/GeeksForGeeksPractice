package com.leetCode.arrays.binarySearch;

import java.util.HashSet;
import java.util.Set;

public class MaxIntegersToChoose1 {
    public static void main(String[] args) {
        int[] banned = {11};
        int n = 7, maxSum = 50;
        MaxIntegersToChoose1 obj = new MaxIntegersToChoose1();
        System.out.println(obj.maxCount(banned, n, maxSum));
    }

    private int maxCount(int[] banned, int n, int maxSum) {
        int sum = 0;
        int maxCount = 0;
        boolean[] isBanNum = new boolean[10001];
        for (int num : banned) {
            isBanNum[num] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (!isBanNum[i]){
                sum+=i;
                if (sum <= maxSum) {
                    maxCount++;
                }
            }
        }
        return maxCount;
    }

    public int maxCountUsingSet(int[] banned, int n, int maxSum) {
        Set<Integer> banSet = new HashSet<>();

        for (int i = 0; i < banned.length; i++) {
            if (banned[i] <= n) {
                banSet.add(banned[i]);
            }
        }
        int sum = 0;
        int maxCount = 0;
        for (int i = 1; i <= n; i++) {
            if (!banSet.contains(i)) {
                sum += i;
                if (sum <= maxSum) {
                    maxCount++;
                }
            }
        }
        return maxCount;
    }
}
