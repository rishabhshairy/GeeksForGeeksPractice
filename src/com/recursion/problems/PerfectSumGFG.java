package com.recursion.problems;

/**
 * https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
 * Given an array arr of size n of non-negative integers and an integer sum,
 * the task is to count all subsets of the given array with a sum equal to a given sum.
 */
public class PerfectSumGFG {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 10, 6, 8};
        int sum = 10;
        System.out.println(perfectSum(arr, arr.length, sum));
    }

    public static int perfectSum(int arr[], int n, int sum) {
        // Your code goes here
        return countPerfectSum(0, arr, n, 0, sum);
    }

    private static int countPerfectSum(int index, int[] arr, int n, int s, int sum) {
        if (index == n) {
            if (s == sum) {
                return 1;
            }
            return 0;
        }
        s += arr[index];
        int leftRecursion = countPerfectSum(index + 1, arr, n, s, sum);
        s -= arr[index];
        int rightRecursion = countPerfectSum(index + 1, arr, n, s, sum);
        return leftRecursion + rightRecursion;
    }
}
