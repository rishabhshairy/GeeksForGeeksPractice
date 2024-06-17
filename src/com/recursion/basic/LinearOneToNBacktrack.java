package com.recursion.basic;

public class LinearOneToNBacktrack {
    public static void main(String[] args) {
        printNum(5, 5);
    }

    public static void printNum(int i, int N) {
        if (i < 1) {
            return;
        }
        printNum(i - 1, N);
        System.out.println(i);
    }
}
