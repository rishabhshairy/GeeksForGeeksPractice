package com.leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public static void main(String[] args) {
        Subsets2 obj = new Subsets2();
        obj.subsetsWithDup(new int[]{1,1,2});
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        if (nums.length == 0) {
            answer.add(new ArrayList<>());
            return answer;
        }
        Arrays.sort(nums);
        solve(nums, 0, answer, new ArrayList<Integer>());
        System.out.println(answer);
        return answer;
    }

    private void solve(int[] nums, int start, List<List<Integer>> answer, ArrayList<Integer> currList) {
        answer.add(new ArrayList<>(currList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            currList.add(nums[i]);
            solve(nums, i + 1, answer, currList);
            currList.remove(currList.size() - 1);
        }

    }
}