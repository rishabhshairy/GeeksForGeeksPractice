package com.leetCode.binarySearch;

import java.util.Arrays;

/**
 * LC 2064
 * https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/description/?envType=daily-question&envId=2024-11-14
 */
public class ProductDistribution {
    public static void main(String[] args) {
        int[] quant = {11, 6};
        System.out.println(minimizedMaximum(6, quant));
    }

    /**
     * Using similar concept of Koko Eating banana
     *
     * @param n
     * @param quantities
     * @return
     */
    public static int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = Arrays.stream(quantities).max().getAsInt();
        int mini = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            int distribute = 0;
            for (int i = 0; i < quantities.length; i++) {
                distribute += Math.ceil((double) quantities[i] / mid);
            }
//            System.out.println(mid + " ::"+distribute);
            if (distribute <= n && distribute > 0) {
                mini = Math.min(mini, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return mini;
    }
}
