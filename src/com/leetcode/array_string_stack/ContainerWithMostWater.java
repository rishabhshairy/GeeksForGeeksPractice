package com.leetcode.array_string_stack;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] test = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(test));
    }

    static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = Integer.MIN_VALUE;

        if (height.length <= 1) {
            return 0;
        }

        while (left < right) {
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
