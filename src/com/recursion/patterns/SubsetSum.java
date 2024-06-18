package com.recursion.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author rshairy
 * GFG Link --> https://www.geeksforgeeks.org/problems/subset-sums2234/1
 */
public class SubsetSum {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(5, 2, 1));
        int n = arr.size();
        ArrayList<Integer> sums = subsetSums(arr, n);
        System.out.println(sums);
    }

    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        findSumsOfSubsets(0, arr, 0, n, result);
        Collections.sort(result);
        return result;

    }

    private static void findSumsOfSubsets(int index, ArrayList<Integer> arr, int sum, int n, ArrayList<Integer> result) {
        if (index == n) {
            result.add(sum);
            return;
        }
        // pick element
        findSumsOfSubsets(index + 1, arr, sum + arr.get(index), n, result);
        // do not pick element
        findSumsOfSubsets(index + 1, arr, sum, n, result);
    }
}
