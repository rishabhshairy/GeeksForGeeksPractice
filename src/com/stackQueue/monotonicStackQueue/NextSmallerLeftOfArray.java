package com.stackQueue.monotonicStackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextSmallerLeftOfArray {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(4, 5, 2, 10, 8);
        ArrayList<Integer> nextSmallerElement = nextSmallerElement(arr, arr.size());
        System.out.println(nextSmallerElement);
    }

    static ArrayList<Integer> nextSmallerElement(List<Integer> arr, int n) {
        // Write your code here.
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.size(); i++) {
            if (stack.isEmpty()) {
                result.add(-1);
            } else if (!stack.isEmpty() && arr.get(i) > stack.peek()) {
                result.add(stack.peek());
            } else if (!stack.isEmpty() && arr.get(i) <= stack.peek()) {

                while (!stack.isEmpty() && arr.get(i) <= stack.peek()) {
                    stack.pop();
                }

                // no elements left in monotonic increasing stack
                if (stack.isEmpty()) {
                    result.add(-1);
                } else {
                    result.add(stack.peek());
                }
            }

            stack.push(arr.get(i));
            System.out.println(stack);
        }
        return result;
    }
}
