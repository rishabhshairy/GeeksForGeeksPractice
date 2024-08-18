package com.leetCode.arrays;

import java.util.Stack;

public class ValidateStackSequence {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5}, popped = {4, 3, 5, 1, 2};
        System.out.println(validateStackSequences(pushed, popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int index = 0;
        Stack<Integer> pushStack = new Stack<>();

        for (Integer num :
                pushed) {
            pushStack.push(num);
            while (!pushStack.isEmpty() && popped[index] == pushStack.peek()) {
                pushStack.pop();
                index++;
            }
        }
        return pushStack.empty();
    }
}
