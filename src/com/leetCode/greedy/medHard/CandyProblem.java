package com.leetCode.greedy.medHard;

import java.util.Arrays;

/**
 * LC 135
 * Amazon
 */
public class CandyProblem {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2};
//        int[] arr = {1, 3, 2, 2, 1};
        CandyProblem obj = new CandyProblem();
        obj.candy(arr);
    }

    /**
     * Trying bruteforce
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] total = new int[n];
        Arrays.fill(total, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                total[i] = total[i - 1] + 1;
            }

        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && total[i] <= total[i + 1]) {
                total[i] = total[i+1] + 1;
            }
        }

        return Arrays.stream(total).sum();
    }
}
