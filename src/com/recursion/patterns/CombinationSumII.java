package com.recursion.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/description/
 *
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 */
public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(arr, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findUniqueCombinations(0, candidates, target, result, new ArrayList<Integer>());
        return result;
    }

    /**
     * @param index
     * @param arr
     * @param target
     * @param result
     * @param nums
     */
    private static void findUniqueCombinations(int index, int[] arr, int target, List<List<Integer>> result, ArrayList<Integer> nums) {

        // base case
        if (target == 0) {
            result.add(new ArrayList<>(nums));
            return;
        }

        // looping through each element
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] > target) {
                break;
            }
            // actual recursion call
            if (arr[i] <= target) {
                nums.add(arr[i]);
                findUniqueCombinations(i + 1, arr, target - arr[i], result, nums);
                nums.remove(nums.size() - 1);
            }
        }

    }
}
