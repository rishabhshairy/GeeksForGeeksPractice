package com.recursion.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 */
public class SubsetSum2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        System.out.println(subsetsWithDup(arr));

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(0, nums, nums.length, result, new ArrayList<Integer>());
        return result;
    }

    private static void findSubsets(int index, int[] arr, int length, List<List<Integer>> result, ArrayList<Integer> ds) {
        result.add(new ArrayList<>(ds));
        for (int i = index; i < length; i++) {
            if (i != index && arr[i] == arr[i - 1]) {
                continue;
            }
            ds.add(arr[i]);
            findSubsets(i + 1, arr, length, result, ds);
            ds.remove(ds.size() - 1);
        }
    }
}
