package com.recursion.problems;

public class SumOfFirstN {
    public static void main(String[] args) {
        System.out.println("Sum from Functional = " + findSumFun(3));
        findSumParam(3, 0);

    }

    /**
     * Below is example of parametrized function
     */
    public static void findSumParam(int i, int sum) {
        if (i < 1) {
            System.out.println("Sum from Param = " + sum);
            return;
        }
        findSumParam(i - 1, sum + i);
    }

    /**
     * Below is example of functional approach
     */
    public static int findSumFun(int n) {
        if (n == 0) {
            return 0;
        }
        return n + findSumFun(n - 1);
    }
}
