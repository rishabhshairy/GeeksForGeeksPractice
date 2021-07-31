package com.leetcode.array_string_stack;

import java.util.Stack;

public class LargestRectangleHIstogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        largestRectangleArea(heights);
    }
    // we will use concept of next smaller to left and right for each element

    public static int largestRectangleArea(int[] heights) {
        int[] nsl = findSmallLeft(heights);
        int[] nsr = findSmallestRight(heights);
        int[] width = new int[heights.length];
        int area = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            width[i] = nsr[i] - nsl[i] - 1;
            area = Math.max(heights[i] * width[i], area);
        }

        return area;
    }

    private static int[] findSmallLeft(int[] heights) {
        int[] nsl = new int[heights.length];
        Stack<Integer> index = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            if (index.isEmpty()) {
                nsl[i] = -1;
            } else if (!index.isEmpty() && heights[i] > heights[index.peek()]) {
                nsl[i] = index.peek();
            } else if (!index.isEmpty() && heights[i] <= heights[index.peek()]) {
                while (!index.isEmpty() && heights[i] <= heights[index.peek()]) {
                    index.pop();
                }

                nsl[i] = index.empty() ? -1 : index.peek();
            }
            index.push(i);
        }
        return nsl;
    }

    private static int[] findSmallestRight(int[] heights) {
        int[] nsr = new int[heights.length];
        Stack<Integer> index = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            if (index.isEmpty()) {
                nsr[i] = heights.length;
            } else if (!index.isEmpty() && heights[i] > heights[index.peek()]) {
                nsr[i] = index.peek();
            } else if (!index.isEmpty() && heights[i] <= heights[index.peek()]) {
                while (!index.isEmpty() && heights[i] <= heights[index.peek()]) {
                    index.pop();
                }

                nsr[i] = index.empty() ? heights.length : index.peek();
            }
            index.push(i);
        }
        return nsr;
    }
}
