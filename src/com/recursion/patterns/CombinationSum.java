package com.recursion.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/description/
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 *  of at least one of the chosen numbers is different.
 */

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = combinationSum(arr, target);
        System.out.println(combinations);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(0, candidates, target, result, new ArrayList<>(), candidates.length);
        return result;

    }

    public static void findCombinations(int index, int[] arr, int target, List<List<Integer>> result, List<Integer> nums, int length) {
        if (index == length) {
            if (target == 0) {
                result.add(new ArrayList<>(nums));
            }
            return;
        }

        if (arr[index] <= target) {
            nums.add(arr[index]);
            findCombinations(index, arr, target - arr[index], result, nums, length);
            nums.remove(nums.size() - 1);
        }
        findCombinations(index + 1, arr, target, result, nums, length);
    }
}
