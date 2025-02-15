package com.company.AmazonOA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetMaxStability {
    public static void main(String[] args) {
        int[] availability = {1, 1, 3};
        int[] reliability = {1, 2, 2};

        List<List<Integer>> availabilitySubsets = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        solve(0, availability, availabilitySubsets, curr);
        System.out.println(availabilitySubsets);

        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < availabilitySubsets.size(); i++) {
            int minVal = Integer.MAX_VALUE;
            int relSum = 0;
            for (int j = 0; j < availabilitySubsets.get(i).size(); j++) {
                int index = availabilitySubsets.get(i).get(j);
                minVal = Math.min(minVal, availability[index]);
                relSum += reliability[index];
            }
            maxi = Math.max(maxi, minVal * relSum);
        }
        System.out.println(maxi);
    }

    private static void solve(int index, int[] arr, List<List<Integer>> subsets, List<Integer> curr) {
        if (curr.size() != 0) {
            subsets.add(new ArrayList<>(curr));
        }


        for (int i = index; i < arr.length; i++) {
            curr.add(i);
            solve(i + 1, arr, subsets, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
