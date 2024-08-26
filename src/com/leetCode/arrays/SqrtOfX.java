package com.leetCode.arrays;

public class SqrtOfX {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(mySqrt(n));
        System.out.println(sqrtBruteForce(n));
    }

    static int sqrtBruteForce(int x) {
        int ans = 0;

        for (int i = 1; i < x; i++) {
            int val = i * i;
            if (val <= x) {
                ans = i;
            } else {
                break;
            }
        }
        return ans;
    }

    static int mySqrt(int x) {

        if (x == 0) {
            return 0;
        }

        int left = 1;
        int right = Integer.MAX_VALUE;
        int mid = 0;
        while (true) {
            mid = (right + left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }
    }

    public static int sqrtN(long n) {
        /*
         * Write your code here
         */
        if (n == 0) {
            return 0;
        }

        long low = 1;
        long high = n;
        long ans = 1;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (mid * mid <= n) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) ans;
    }
}
