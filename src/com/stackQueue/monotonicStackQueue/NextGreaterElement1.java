package com.stackQueue.monotonicStackQueue;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        NextGreaterElement1 obj = new NextGreaterElement1();
        obj.nextGreaterElement(nums1, nums2);
    }

    /**
     * Use Map to store next greater from num2
     * and then re-use the map to find it from num1
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> ngeMap = new LinkedHashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num2 : nums2) {
            while (!stack.isEmpty() && num2 > stack.peek()) {
                ngeMap.put(stack.pop(), num2);
            }
            stack.push(num2);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = ngeMap.getOrDefault(nums1[i], -1);
//            System.out.println(result[i]);
        }

        return result;
    }
}
