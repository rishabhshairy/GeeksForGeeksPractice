package com.slidingwindow.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CountOfNiceSubArrays {

    public static void main(String[] args) {
        System.out.println(1 % 2);
    }

    /**
     * Optimal solution
     * Similar concept
     * f (nums, k) - f (nums, k-1)
     *
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k - 1);
    }

    private int solve(int[] nums, int k) {
        int left = 0, right = 0, count = 0, sum = 0;
        if (k < 0) {
            return 0;
        }
        while (right < nums.length) {

            sum += nums[right] % 2;

            // using another while loop we shrink the window
            while (sum > k) {
                sum -= nums[left] % 2;
                left++;
            }
            count += (right - left + 1); // window size will be added to count
            right++;
        }

        return count;
    }

    /**
     * Brute force solution
     *
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarraysBetter(int[] nums, int k) {

        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> oddMap = new LinkedHashMap<>();
        oddMap.put(sum, 1);

        int right = 0;
        while (right < nums.length) {
            sum += nums[right] % 2;
            if (oddMap.containsKey(sum - k)) {
                count += oddMap.get(sum - k);
            }
            oddMap.put(sum, oddMap.getOrDefault(sum, 0) + 1);
            right++;
        }
        return count;
    }
}
