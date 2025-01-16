package com.stackQueue.monotonicStackQueue;

import java.util.Stack;

/**
 * Company Apple, JPMC
 */
public class SumOfSubarrayRanges {
    public static void main(String[] args) {
//        int[] arr = {4, -2, -3, 4, 1};
        int[] arr = {1, 3, 3};
        SumOfSubarrayRanges obj = new SumOfSubarrayRanges();
        System.out.println(obj.subArrayRanges(arr));
    }

    /**
     * From close observation, this question boils down to
     * SumOfSubarrMax - SumOfSubArrMin
     *
     * @param nums
     * @return
     */
    public long subArrayRanges(int[] nums) {

        /**
         * find Sub Array Max sum
         */
        int[] ngeIndex = nextGreater(nums);
        int[] pgeeIndex = previousGreater(nums);
        long sumOfSubArrMax = findSumOfSubArrMax(ngeIndex, pgeeIndex, nums);

        int[] psee = findPreviousSmallerEqualIndex(nums);
        int[] nse = findNextSmallerIndex(nums);
        long sumOfSubArrMins = findSumOfSubArrMins(nse, psee, nums);

        return sumOfSubArrMax - sumOfSubArrMins;
    }

    private long findSumOfSubArrMins(int[] nse, int[] psee, int[] arr) {
        long sum = 0;
        long mod = (long) (1e9 + 7);

        for (int i = 0; i < arr.length; i++) {

            long left = i - psee[i];
            long right = nse[i] - i;

            sum = (sum + (right * left * arr[i])) % mod;

        }
        return sum % mod;
    }

    private long findSumOfSubArrMax(int[] ngeIndex, int[] pgeeIndex, int[] nums) {
        long sum = 0;
        long mod = (long) (1e9 + 7);

        for (int i = 0; i < nums.length; i++) {
            long left = i - pgeeIndex[i];
            long right = ngeIndex[i] - i;

            sum = (sum + (left * right * nums[i]) % mod) % mod;
        }

        return sum % mod;
    }

    private int[] previousGreater(int[] nums) {
        int n = nums.length;
        int[] pgeeIndex = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }
            pgeeIndex[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pgeeIndex;
    }

    private int[] nextGreater(int[] nums) {
        int n = nums.length;
        int[] ngeIndex = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                stack.pop();
            }
            ngeIndex[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return ngeIndex;
    }

    private int[] findNextSmallerIndex(int[] arr) {
        int[] nseIndex = new int[arr.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            nseIndex[i] = stack.isEmpty() ? arr.length : stack.peek();

            stack.push(i);
        }
        return nseIndex;
    }

    // previous smaller element index for each element
    private int[] findPreviousSmallerEqualIndex(int[] arr) {
        int n = arr.length;
        int[] psee = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            psee[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return psee;
    }
}
