package com.stackQueue.monotonicStackQueue;

import java.util.Stack;

public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        SumOfSubarrayMinimums obj = new SumOfSubarrayMinimums();
        System.out.println(obj.sumSubarrayMins(arr));
    }

    public int sumSubarrayMins(int[] arr) {
        long sum = 0;
        int mod = (int) (1e9 + 7);

        int[] psee = findPreviousSmallerEqualIndex(arr);
        int[] nse = findNextSmallerIndex(arr);

        for (int i = 0; i < arr.length; i++) {

            long left = i - psee[i];
            long right = nse[i] - i;

            sum = (sum + (right * left * arr[i])) % mod;

        }
        return (int) sum % mod;
    }

    private int[] findNextSmallerIndex(int[] arr) {
        int[] nseIndex = new int[arr.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            nseIndex[i] = stack.isEmpty() ? arr.length : stack.peek();

            stack.push(i);
        }
        return nseIndex;
    }

    // previous smaller element index for each element
    private int[] findPreviousSmallerEqualIndex(int[] arr) {
        int n = arr.length;
        int[] psee = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            psee[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return psee;
    }

}
