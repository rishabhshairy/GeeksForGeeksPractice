package com.leetCode.bitManipulation;

public class CombinationNumberGreaterZero {
    public static void main(String[] args) {
        int[] cand = {16, 17, 71, 62, 12, 24, 14};
        CombinationNumberGreaterZero obj = new CombinationNumberGreaterZero();
        System.out.println(obj.largestCombination(cand));
    }

    /**
     * Approach --> Find the most ith set bits in 24 bit integer
     * Increase all the ith set bit in array
     * find max i-th set bits in array
     * @param candidates
     * @return
     */
    public int largestCombination(int[] candidates) {
        int[] bits = new int[24];

        for (int i = 0; i < bits.length; i++) {
            for (int num : candidates) {
                // check if i-th bit is set in num
                if ((num & (1 << i)) != 0) {
                    bits[i]++;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < bits.length; i++) {
            max = Math.max(bits[i], max);
        }
        return max;
    }
}