package com.stackQueue.monotonicStackQueue;

import java.util.Stack;

/**
 * VVIMP
 * Monotonic decreasing stack
 */
public class NGENonCircular {
    public static void main(String[] args) {
        int[] nums = {5, 7, 1, 2, 6, 0};
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int index = nums.length - 1; index >= 0; index--) {

            if (stack.isEmpty()) {
                result[index] = -1;
            } else if (!stack.isEmpty() && nums[index] < stack.peek()) {
                result[index] = stack.peek();
            } else {
                while (!stack.isEmpty() && nums[index] >= stack.peek()) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    result[index] = -1;
                } else {
                    result[index] = stack.peek();
                }
            }
            stack.push(nums[index]);
            System.out.println(stack);
        }

        for (int num : result) {
            System.out.print(num+" ");
        }
    }
}
