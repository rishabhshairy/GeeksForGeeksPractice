package com.codingNinja.top100Tree.medium;

import java.util.Stack;

public class VerifyPreOrderForBST {
    public static void main(String[] args) {
        int[] pre = {40, 30, 35, 80, 100};
        isBSTPreorder(pre);
    }
    public static boolean isBSTPreorder(int[] arr) {
        // Write your code here.
        Stack<Integer> nodeStack = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < root) {
                return false;
            }

            while (!nodeStack.isEmpty() && arr[i] > nodeStack.peek()) {
                root = nodeStack.pop();

            }
            nodeStack.push(arr[i]);
        }
        return true;
    }
}
