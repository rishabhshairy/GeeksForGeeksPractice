package com.leetCode.array_string_stack;

public class SumUsingBits {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println(getSum(a, b));
    }

    static int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }

        return getSum(a ^ b, (a & b) << 1);
    }
}
