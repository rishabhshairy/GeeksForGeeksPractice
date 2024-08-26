package com.codingNinja.crackCodingInterview.easy;

import java.util.Arrays;

public class SwapAdjacentBitPairs {
    public static void main(String[] args) {
        int n = 9;
        swapAdjacent(n);
    }

    public static int swapAdjacent(int n) {
        // Write your code here.
        String binary = Integer.toBinaryString(n);
        StringBuilder fullBinary = new StringBuilder();
        for (int i = 0; i < 32 - binary.length(); i++) {
            fullBinary.append('0');
        }
        fullBinary.append(binary);
        char[] binaryChars = fullBinary.toString().toCharArray();
        for (int i = 0; i < binaryChars.length; i += 2) {
            char temp = binaryChars[i];
            binaryChars[i] = binaryChars[i + 1];
            binaryChars[i + 1] = temp;
        }
        return Integer.parseInt(String.valueOf(binaryChars),2);
    }
}
