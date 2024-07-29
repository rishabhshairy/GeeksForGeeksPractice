package com.codingNinja.crackCodingInterview;

public class SwapNumWithoutVar {
    public static void main(String[] args) {
        int x = 10;
        int y = 12;
        swapNumber(x, y);
    }

    public static int[] swapNumber(int x, int y) {
        // Write your code here.
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;

        return new int[]{x, y};
    }
}
