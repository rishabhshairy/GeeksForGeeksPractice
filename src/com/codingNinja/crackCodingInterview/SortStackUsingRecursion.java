package com.codingNinja.crackCodingInterview;

import java.util.Stack;

public class SortStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

    }

    public static void sortStack(Stack<Integer> stack) {
        // Write your code here.
        if (!stack.isEmpty()) {
            int x = stack.pop();
            sortStack(stack);
            sortInserted(stack, x);
        }
    }

    private static void sortInserted(Stack<Integer> stack, int x) {
        // base case
        if (stack.isEmpty() || x > stack.peek()) {
            stack.push(x);
            return;
        }

        int top = stack.pop();
        sortInserted(stack, x);
        stack.push(top);
    }
}
