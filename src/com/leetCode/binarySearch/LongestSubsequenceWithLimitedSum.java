package com.leetCode.binarySearch;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-subsequence-with-limited-sum/
 */
public class LongestSubsequenceWithLimitedSum {
    public static void main(String[] args) {

    }

    /**
     * Using binary search, prefix sum
     *
     * @param nums
     * @param queries
     * @return
     */
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length - 1;
        int[] answer = new int[m];

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        for (int i = 0; i < m; i++) {
            int q = queries[i];
            int low = 0;
            int high = nums.length;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] == q) {
                    answer[i] = mid + 1;
                    break;
                } else if (nums[mid] < q) {
                    answer[i] = mid + 1;
                    low = mid + 1;
                } else {
                    high = mid - 1;

                }
            }
        }
        return answer;
    }

    /**
     * Brute Force
     *
     * @param nums
     * @param queries
     * @return
     */
    public int[] answerQueriesBruteForce(int[] nums, int[] queries) {

        int n = nums.length;
        int m = queries.length;
        int[] answer = new int[m];
        Arrays.sort(nums);
        for (int i = 0; i < m; i++) {
            int size = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] <= queries[i]) {
                    queries[i] -= nums[j];
                    size++;
                } else {
                    break;
                }
            }
            answer[i] = size;
        }
        return answer;
    }
}
