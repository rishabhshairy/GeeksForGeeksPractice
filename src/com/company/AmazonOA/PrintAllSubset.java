package com.company.AmazonOA;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubset {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solve(0, arr, subsets, curr);
        System.out.println(subsets);
    }

    private static void solve(int index, int[] arr, List<List<Integer>> subsets, List<Integer> curr) {
        subsets.add(new ArrayList<>(curr));

        for (int i = index; i < arr.length; i++) {
            curr.add(i);
            solve(i + 1, arr, subsets, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
