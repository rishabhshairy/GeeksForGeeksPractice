package com.stackQueue.monotonicStackQueue;

public class TrappingWater {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int n = a.length;
        System.out.println(trap(a));
    }

    /**
     * Two pointer approach
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, total = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (leftMax > height[left]) {
                    total += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (rightMax > height[right]) {
                    total += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return total;
    }

    /**
     * This is left max and right max approach
     *
     * @param a
     * @param n
     * @return
     */
    private static int waterStored(int[] a, int n) {

        int trappedWater = 0;

        for (int i = 0; i < n; i++) {

            int leftMax = a[i];
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, a[j]);
            }

            int rightMax = a[i];
            for (int j = i + 1; j < n; j++) {
                rightMax = Math.max(rightMax, a[j]);
            }

            trappedWater += Math.min(leftMax, rightMax) - a[i];
        }

        return trappedWater;
    }

    /*
     * this is O(n) solution*/
    static int trappingWater(int arr[], int n) {

        // Your code here
        int[] left = new int[n];
        int[] right = new int[n];

        int trappedWater = 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            left[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            right[i] = max;
        }

        // Calculating water
        for (int i = 0; i < n; i++) {
            int a = left[i];
            int b = right[i];
            trappedWater += Math.min(a, b) - arr[i];
        }

        return trappedWater;
    }
}
