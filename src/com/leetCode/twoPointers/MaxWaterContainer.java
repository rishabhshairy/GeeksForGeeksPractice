package com.leetCode.twoPointers;

public class MaxWaterContainer {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int area = 0;

        while (left < right) {
            area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            // since we want to maximize container--> difference of walls should be minimum
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    /**
     * Brute Force
     *
     * @param heights
     * @return
     */
    public int maxAreaBruteForce(int[] heights) {
        int area = 0;
        int res = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                area = Math.min(heights[i], heights[j]) * (j - i);
                res = Math.max(res, area);
            }
        }
        return res;
    }
}
