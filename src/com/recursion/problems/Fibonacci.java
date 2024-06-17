package com.recursion.problems;

public class Fibonacci {
    public static void main(String[] args) {
        int num = 13;
        int n = fibonacci(num);
        System.out.println(n);
    }

    private static int fibonacci(int num) {
        if (num <= 1) {
            return num;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

}
