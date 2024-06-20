package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationWithSwap {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permute(arr);

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findPermutationsWithSwap(0, nums, result);
        return result;
    }

    private static void findPermutationsWithSwap(int index, int[] arr, List<List<Integer>> result) {
        if (index == arr.length) {
            List<Integer> permutedList = new ArrayList<>();
            for (int num :
                    arr) {
                permutedList.add(num);
            }
            result.add(new ArrayList<>(permutedList));
            System.out.println(result);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, i, index);
            findPermutationsWithSwap(index + 1, arr, result);
            swap(arr, i, index);

        }
    }

    private static void swap(int[] arr, int num1, int num2) {
        System.out.println("Swapping " + arr[num1] + " & " + arr[num2]);
        int temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }
}
