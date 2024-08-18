package com.codingNinja.crackCodingInterview.easy;

import java.util.ArrayList;

public class NearestNumberWithSetBits {
    public static void main(String[] args) {
        System.out.println(nearestNumbersCountApproach(6));
    }

    public static ArrayList<Integer> nearestNumbersCountApproach(int n) {
        // Write Your Code here
        ArrayList<Integer> result = new ArrayList<>();
        int countBitsN = countBits(n);
        for (int i = n + 1; i < Integer.MAX_VALUE - 1; i++) {
            if (countBits(i) == countBitsN) {
                result.add(i);
                break;
            }
        }

        for (int i = n - 1; i >= 1; i--) {
            if (countBits(i) == countBitsN) {
                result.add(i);
                break;
            }
        }
        return result;
    }

    private static int countBits(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }
}
