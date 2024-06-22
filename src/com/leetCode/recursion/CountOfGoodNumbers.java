package com.leetCode.recursion;

/**
 * https://leetcode.com/problems/count-good-numbers/description/
 * <p>
 * A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).
 * <p>
 * For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime.
 * However, "3245" is not good because 3 is at an even index but is not even.
 * Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.
 * <p>
 * A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.
 */
public class CountOfGoodNumbers {
    static long MOD = 1_000_000_007;
    public static void main(String[] args) {
        long n = 50;
        countGoodNumbers(n);
    }

    public static int countGoodNumbers(long n) {
        final int evenWays = 5; // 0,2,4,6,8
        final int oddWays = 4; // 2,3,5,7

        long evenPlaces = (n + 1) / 2;
        long oddPlaces = n / 2;

        int ans = (int) (((myPow(5, evenPlaces)%MOD) * (myPow(4,oddPlaces)%MOD))%MOD);
        return ans;
    }

    public static long myPow(long x, long n) {
        long ans = 1L;

        long power = n;

        while (power > 0) {
            if (power % 2 == 0) {
                x = (x * x)%MOD;
                power = power / 2;
            } else {
                ans = (ans * x)%MOD;
                power = power - 1;
            }
        }
        return ans%MOD;
    }
}
