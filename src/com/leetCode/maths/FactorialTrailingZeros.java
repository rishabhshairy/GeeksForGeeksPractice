package com.leetCode.maths;

public class FactorialTrailingZeros {

    /**
     * Better Approach
     * Total Count of 5's as prime factorial
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        if (n < 0) {
            return -1;
        }
        int count = 0;
        for (int i = 5; i >= 1; i *= 5) {
            count += (n / i);
        }
        return count;
    }
}
