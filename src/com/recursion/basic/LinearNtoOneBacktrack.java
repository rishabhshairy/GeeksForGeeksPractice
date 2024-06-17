package com.recursion.basic;

public class LinearNtoOneBacktrack {
    public static void main(String[] args) {
        printNum(1, 5);
    }

    public static void printNum(int i, int N) {
        if (i > N) {
            return;
        }
        printNum(i + 1, N);
        System.out.println(i);
    }
}
