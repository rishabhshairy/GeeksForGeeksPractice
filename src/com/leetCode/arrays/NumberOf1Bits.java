package com.leetCode.arrays;

public class NumberOf1Bits {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(hammingWeight(n));
    }

    static int hammingWeight(int n) {
        int count = 0;
        String s = "11111111111111111111111111111101";
        for (char bit :
                Integer.toString(n, 2).toCharArray()) {
            if (((Integer.parseInt(String.valueOf(bit)) ^ 1) == 0)) {
                count++;
            }
        }
        return count;
    }
}
