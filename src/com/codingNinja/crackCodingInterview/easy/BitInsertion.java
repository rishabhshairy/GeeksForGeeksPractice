package com.codingNinja.crackCodingInterview.easy;

public class BitInsertion {
    public static void main(String[] args) {
        System.out.println(bitInsertion(21321454, 129, 11, 30));
    }

    public static int bitInsertion(int x, int y, int a, int b) {
        // Write your code here
        int allOnes = ~0;

        int left = allOnes << (b + 1);

        int right = ((1 << a) - 1);

        int mask = left | right;

        int xCleared = x & mask;

        int bShifted = y << a;

        return xCleared | bShifted;
    }
}
