package com.leetcode.array_string_stack;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] test = {9};
        int[] answer = plus(test);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    static int[] plus(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] newArr = Arrays.copyOf(digits, n + 1);
        newArr[0] = 1;
        return newArr;
    }
}
