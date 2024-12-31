package com.recursion.patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenerateSubArrays {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        List<List<Integer>> minSubArr = new ArrayList<>();
        generateSubArray(0, 0, arr, minSubArr);
        System.out.println(minSubArr.stream().flatMap(List::stream).mapToInt(i -> i).sum());
    }

    private static void generateSubArray(int start, int end, int[] arr, List<List<Integer>> subArrays) {
        if (end == arr.length) {
            return;
        }
        if (start > end) {
            generateSubArray(0, end + 1, arr, subArrays);
        } else {
            List<Integer> curr = new ArrayList<>();
            int mini = Integer.MAX_VALUE;
            for (int i = start; i < end; i++) {
                mini = Math.min(mini, arr[i]);
            }
            mini = Math.min(mini, arr[end]);
            curr.add(mini);
            subArrays.add(curr);
            generateSubArray(start + 1, end, arr, subArrays);
        }
    }
}
