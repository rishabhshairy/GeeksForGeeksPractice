package com.leetCode.arrays;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        int q = divideTwoIntegers.divide(dividend, divisor);
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        long q = dividend / divisor;
        return (int) q % ((int) Math.pow(2, 31) - 1);
    }
}
