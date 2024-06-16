package com.leetCode.array_string_stack;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 20;
        isHappy(n);
    }

    static boolean isHappy(int n) {
        boolean isNumHappy = false;

        if (n == 1) {
            return true;
        }
        int sum = 0;
        while (true) {
            sum = getSum(n);

            if (sum / 10 == 0) {
                if (sum == 1 || sum == 7) {
                    isNumHappy = true;
                } else {
                    break;
                }
            }
            n = sum;
        }
        return isNumHappy;

    }

    static int getSum(int num) {
        int sumOfSquares = 0;
        while (num != 0) {
            sumOfSquares += Math.pow(num % 10, 2);
            num = num / 10;
        }
        return sumOfSquares;
    }
}
