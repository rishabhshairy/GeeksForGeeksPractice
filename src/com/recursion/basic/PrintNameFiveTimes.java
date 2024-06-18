package com.recursion.basic;

/**
 * TC --> O(n)
 * SC --> O(n) --> Computer's internal memory
 */
public class PrintNameFiveTimes {
    public static void main(String[] args) {
        int n = 5;
        printName(1,n);
    }

    public static void printName(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println("Rishabh");
        printName(i + 1, n);
    }
}


