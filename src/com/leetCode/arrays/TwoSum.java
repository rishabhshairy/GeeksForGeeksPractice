package com.leetCode.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(twoSum2Pointer(new int[]{-18, 12, 3, 0}, -6));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int nextNum = target - nums[i];
            if (map.containsKey(nextNum)) {
                ans[0] = map.get(nextNum);
                ans[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        System.out.println(ans[0] + " " + ans[1]);
        return ans;
    }

    public static int[] twoSum2Pointer(int[] nums, int target) {
        int[] ans = new int[2];
        int[][] indexNum = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            indexNum[i][0] = i; // storing index
            indexNum[i][1] = nums[i]; // storing number
        }

        Arrays.sort(indexNum, Comparator.comparingInt(i -> i[1]));


        // For duplicate element
        if (nums.length == 2 && (nums[0] + nums[1] == target)) {
            return new int[]{0, 1};
        }

        int pLeft = 0;
        int pRight = nums.length - 1;

        while (pLeft < pRight) {
            int sum = indexNum[pLeft][1] + indexNum[pRight][1];
            System.out.println(sum);
            if (sum > target) {
                pRight--;
            } else if (sum < target) {
                pLeft++;
            } else if (sum == target) {
                ans[0] = indexNum[pLeft][0];
                ans[1] = indexNum[pRight][0];
                break;
            }
        }

        return ans;
    }
}
