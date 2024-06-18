package com.recursion.basic;

public class LinearOneToN {
    public static void main(String[] args) {
        printNum(1,5);
    }

    public static void printNum(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println(i);
        printNum(i + 1, n);
    }
}
