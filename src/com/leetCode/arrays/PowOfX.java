package com.leetCode.arrays;

public class PowOfX {

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2147483648;
        System.out.println(myPow(x, n));
    }

    static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            if (x == -1) {
                return -1;
            }
            if (n == Integer.MIN_VALUE) {
                n = n + 1;
            }
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);

    }
}

