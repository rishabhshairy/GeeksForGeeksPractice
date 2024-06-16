package com.leetCode.array_string_stack;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        int n = 16;
        ValidPerfectSquare perfectSquare = new ValidPerfectSquare();
        System.out.println(perfectSquare.isPerfectSquare(n));
    }

    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            }

            if (mid * mid > num) {
                right = (int) (mid - 1);
            } else {
                left = (int) (mid - 1);
            }
        }
        return false;
    }
}
