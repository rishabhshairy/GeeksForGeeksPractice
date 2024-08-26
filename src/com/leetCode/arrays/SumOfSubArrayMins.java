package com.leetCode.arrays;

import java.util.Stack;

public class SumOfSubArrayMins {
    int totalSum = 0;

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
    }

/*  TLE solution
    public int sumSubarrayMins(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        Stack<Integer> numStack = new Stack<>();
        int index = 0;
        int[] sumArr = {totalSum};
        solve(arr, numStack, sumArr, index);
        return sumArr[0];
    }

    private void solve(int[] arr, Stack<Integer> numStack, int[] totalSum, int index) {
        if (index == arr.length - 1) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            numStack.add(arr[i]);
        }
        while (numStack.size() != 1) {
           totalSum[0]  += Collections.min(numStack);
            numStack.pop();
        }
        numStack.clear();
        solve(arr, numStack, totalSum, index + 1);
    }*/


    /* Monotonic Stack solution  fails for vv large test case */

//    public static int sumSubarrayMins(int[] A) {
//
//        Stack<int[]> prevLess = new Stack<>();
//        Stack<int[]> nextLess = new Stack<>();
//
//        int[] leftDistance = new int[A.length];
//        int[] rightDistance = new int[A.length];
//
//        for (int i = 0; i < A.length; i++) {
//
//            // PLE
//            while (!prevLess.isEmpty() && prevLess.peek()[0] >= A[i]) {
//                prevLess.pop();
//            }
//            leftDistance[i] = prevLess.isEmpty() ? i + 1 : i - prevLess.peek()[1];
//            prevLess.push(new int[]{A[i], i});
//        }
//
//        for (int i = A.length - 1; i >= 0; i--) {
//            while (!nextLess.isEmpty() && nextLess.peek()[0] > A[i]) {
//                nextLess.pop();
//            }
//            rightDistance[i] = nextLess.isEmpty() ? A.length - i : nextLess.peek()[1] - i;
//            nextLess.push(new int[]{A[i], i});
//        }
//        int ans = 0;
//        int mod = (int) (1e9 + 7);
//        for (int i = 0; i < A.length; i++) {
//            ans = (ans + A[i] * leftDistance[i] % mod * rightDistance[i] % mod) % mod;
//        }
//        return ans;
//    }

    /* DP soln*/

    public static int sumSubarrayMins(int[] A) {
        Stack<Integer> numStack = new Stack<>();
        int total = 0, mod = (int) (1e9 + 7);
        int[] dp = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            while (!numStack.isEmpty() && A[numStack.peek()] > A[i]) {
                numStack.pop();
            }
            if (numStack.isEmpty()) {
                dp[i] = (i + 1) * A[i];
            } else {
                dp[i] = dp[numStack.peek()] + (i - numStack.peek()) * A[i];
            }
            total = (total + dp[i]) % mod;
            numStack.push(i);
        }
        return total;
    }
}
