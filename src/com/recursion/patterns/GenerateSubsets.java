package com.recursion.patterns;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();
        generateAllSubsets(0, arr, n, result, new ArrayList<Integer>());
        System.out.println(result);
        System.out.println(result.size());
    }

    private static void generateAllSubsets(int index, int[] arr, int n, List<List<Integer>> result, ArrayList<Integer> nums) {
        if (index == n) {
            result.add(new ArrayList<>(nums));
            return;
        }
        nums.add(arr[index]);
        generateAllSubsets(index + 1, arr, n, result, nums);
        nums.remove(nums.size() - 1);
        generateAllSubsets(index + 1, arr, n, result, nums);
    }
}
