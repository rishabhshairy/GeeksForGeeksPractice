package com.slidingwindow.medium;

import java.util.Arrays;

public class FrequencyOfMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        int maxi = 1;
        long sum = 0;
        int left = 0, right = 0;
        int len = 0;

        Arrays.sort(nums);

        while (right < nums.length) {
            sum += nums[right];
            len = right - left + 1;
            long want = (long) nums[right] * len;
            long have = sum + k;
            if (left + 1 <= right && want > have) {
                sum -= nums[left];
                left++;
                len = right - left + 1;
            }
            maxi = Math.max(maxi, len);
            right++;
        }
        return maxi;
    }
}
