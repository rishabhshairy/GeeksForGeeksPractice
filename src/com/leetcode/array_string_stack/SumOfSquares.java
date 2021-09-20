package com.leetcode.array_string_stack;

public class SumOfSquares {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new SumOfSquares().judgeSquareSum(n));
    }

    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = (int) (c - a * a);

            if (binarySearch(0, b, b)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int start, int end, int num) {
        if (start > end) {
            return false;
        }

        long mid = start + (end - start) / 2;
        if (mid * mid == num) {
            return true;
        }

        if (mid * mid > num) {
            return binarySearch(start, (int) (mid - 1), num);
        }
        return binarySearch((int) (mid + 1), end, num);
    }
}
