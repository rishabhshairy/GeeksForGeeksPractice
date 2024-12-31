package com.stackQueue.monotonicStackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class NextSmallerToRight {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 4, 6, 7, 3, 7, 8, 1);
        ArrayList<Integer> nextSmallerElement = nextSmallerElement(arr, arr.size());
        System.out.println(nextSmallerElement);
    }

    static ArrayList<Integer> nextSmallerElement(List<Integer> arr, int n) {
        // Write your code here.
        int[] result = new int[arr.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.size() - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                result[i] = -1;
            } else if (!stack.isEmpty() && arr.get(i) > stack.peek()) {
                result[i] = stack.peek();
            } else if (!stack.isEmpty() && arr.get(i) <= stack.peek()) {

                while (!stack.isEmpty() && arr.get(i) <= stack.peek()) {
                    stack.pop();
                }

                // no elements left in monotonic increasing stack
                if (stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
            }

            stack.push(arr.get(i));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : result) {
            ans.add(num);
        }
        return ans;
    }
}
