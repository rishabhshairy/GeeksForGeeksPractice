package com.stackQueue.monotonicStackQueue;

import java.util.Stack;

/**
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
 * return the next greater number for every element in nums.
 * <p>
 * The next greater number of a number x is the first greater number to its traversing-order next in the array,
 * which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 */
public class NextGreaterElement2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        NextGreaterElement2 obj = new NextGreaterElement2();
        obj.nextGreaterElements(nums);
    }

    /**
     * Since this is a circular array
     * lets take n = nums.length
     * and iterate 2 times
     * and consider modIndex = index % n
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for (int index = 2 * n - 1; index >= 0; index--) {

            int modIndex = index % n;
            if (stack.isEmpty()) {
                result[modIndex] = -1;
            } else if (!stack.isEmpty() && nums[modIndex] < stack.peek()) {
                result[modIndex] = stack.peek();
            } else {
                while (!stack.isEmpty() && nums[modIndex] >= stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    result[modIndex] = -1;
                } else {
                    result[modIndex] = stack.peek();
                }
            }
            stack.push(nums[modIndex]);
        }
        for (int num : result) {
            System.out.println(num);
        }
        return result;
    }
}
