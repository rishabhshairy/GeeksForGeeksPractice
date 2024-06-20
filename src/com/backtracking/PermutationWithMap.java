package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithMap {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(permute(arr));
    }

    /**
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        findPermutations(nums, freq, result, new ArrayList<>());
        return result;
    }

    private static void findPermutations(int[] arr, boolean[] freq, List<List<Integer>> result, List<Integer> nums) {
        if (nums.size() == arr.length) {
            result.add(new ArrayList<>(nums));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                nums.add(arr[i]);
                findPermutations(arr, freq, result, nums);
                nums.remove(nums.size() - 1);
                freq[i] = false;
            }
        }
    }
}
