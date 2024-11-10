package com.leetCode.bitManipulation;

public class CountSetBits {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(countSetBitsLoopNumber(n));
        System.out.println(countSetBits(n));
    }

    /**
     * This approach check each bits
     *
     * @param n
     * @return
     */
    private static int countSetBits(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    private static int countSetBitsLoopNumber(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            // >> is divide
            // << is multiply
            n >>= 1;

        }
        return count;
    }
}
