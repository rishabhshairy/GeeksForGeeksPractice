package com.leetCode.twoPointers;

public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLenTwoPointer(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int curr = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                curr++;

                if (sum >= target) {
                    res = Math.min(curr, res);
                    break;
                }
            }
            //System.out.println(sum);
        }
        return res < Integer.MAX_VALUE ? res : 0;
    }

    public static int minSubArrayLenTwoPointer(int target, int[] nums) {
        int end = 0, sum = 0, res = Integer.MAX_VALUE;

        for (int start = 0; start < nums.length; start++) {
            sum += nums[start];

            while (sum >= target) {
                res = Math.min(res, start - end + 1);
                sum -= nums[end++]; // reducing window size
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
