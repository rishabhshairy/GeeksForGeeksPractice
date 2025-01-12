package com.stackQueue.monotonicStackQueue;

import java.util.Stack;

public class LargestHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        largestRectangleArea(heights);
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 1) {
            return heights[0];
        }

        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int maxArea = Integer.MIN_VALUE;

        while (index < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[index]) {
                stack.push(index++);
            } else {
//                System.out.println(stack);
                int top = stack.pop();
                int currArea = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                maxArea = Math.max(maxArea, currArea);
            }
        }

        while (!stack.isEmpty()) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (stack.isEmpty() ? index : index - stack.peek() - 1));
        }
        return maxArea;
    }

}
