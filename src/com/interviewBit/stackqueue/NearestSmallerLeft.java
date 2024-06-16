package com.interviewBit.stackqueue;

import java.util.Stack;

public class NearestSmallerLeft {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        for (Integer n :
                prevSmaller(arr)) {
            System.out.println(n);
        }
    }

    public static int[] prevSmaller(int[] A) {
        int[] answer = new int[A.length];
        Stack<Integer> nums = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            if (nums.isEmpty()) {
                answer[i] = -1;
            } else if (!nums.isEmpty() && A[i] > nums.peek()) {
                answer[i] = nums.peek();
            } else if (!nums.isEmpty() && A[i] <= nums.peek()) {
                while (!nums.isEmpty() && A[i] <= nums.peek()) {
                    nums.pop();
                }

                answer[i] = nums.isEmpty() ? -1 : nums.peek();
            }
            nums.push(A[i]);
        }
        return answer;
    }
}
