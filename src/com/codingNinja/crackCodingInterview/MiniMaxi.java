package com.codingNinja.crackCodingInterview;

import java.util.ArrayList;

public class MiniMaxi {
    public static void main(String[] args) {
        System.out.println(findMinMax(5, 4));
    }

    public static ArrayList<Integer> findMinMax(int a, int b) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<>();

        int i = (a ^ b) & (-1 * ((a < b) ? 1 : 0));
        int minVal = b ^ i;
        int maxVal = a ^ i;

        result.add(minVal);
        result.add(maxVal);
        return result;
    }
}
