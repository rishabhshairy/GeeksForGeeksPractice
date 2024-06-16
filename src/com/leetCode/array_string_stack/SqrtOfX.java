package com.leetCode.array_string_stack;

public class SqrtOfX {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(mySqrt(n));
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
}
