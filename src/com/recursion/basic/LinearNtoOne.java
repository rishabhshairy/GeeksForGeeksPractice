package com.recursion.basic;

public class LinearNtoOne {
    public static void main(String[] args) {
        printNum(5, 5);
    }

    public static void printNum(int i, int n) {
        if (i < 1) {
            return;
        }
        System.out.println(i);
        printNum(i - 1, n);
    }
}
