package com.recursion.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumIII {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> hash = new HashSet<>();
//        findCombinations(k, 0, n, hash, result, new ArrayList<>());
        int s = n;
        findCombinationAnotherApproach(1, k, s, n, new ArrayList<>(), result);
        return result;
    }

    /**
     * @param k
     * @param s
     * @param sum
     * @param hash
     * @param result
     */
    private static void findCombinations(int k, int s, int sum, Set<Integer> hash, List<List<Integer>> result, List<Integer> answer) {
        if (answer.size() == k && s == sum) {
            result.add(new ArrayList<>(answer));
            return;
        }
        // here for loop init makes sure we are taking number greater than prev number
        for (int i = answer.isEmpty() ? 1 : answer.get(answer.size() - 1); i < 10; i++) {

            if (hash.contains(i)) {
                continue;
            }
            hash.add(i);
            answer.add(i);
            s += i;
            findCombinations(k, s, sum, hash, result, answer);
            s -= answer.get(answer.size() - 1);
            hash.remove(i);
            answer.remove(answer.size() - 1);

        }
    }

    private static void findCombinationAnotherApproach(int index, int k, int s, int sum, List<Integer> answer, List<List<Integer>> result) {
        if (sum == 0 && answer.size() == k) {
            result.add(new ArrayList<>(answer));
            return;
        }
        // s is copy of sum , since we will reduce sum
        for (int num = index; num < s; num++) {
            if (num <= sum && num <= 9) {
                answer.add(num);
                findCombinationAnotherApproach(num + 1, k, s, sum - num, answer, result);
                answer.remove(answer.size() - 1);
            }
        }
    }
}
