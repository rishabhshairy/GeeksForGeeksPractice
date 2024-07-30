package com.codingNinja.crackCodingInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SimilaritiesInArray {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> findSimilarity(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m) {
        // Write your code here.
        Collections.sort(arr1);
        Collections.sort(arr2);
        ArrayList<Integer> answer = new ArrayList<>();

        int i = 0, j = 0, count = 0;
        while (i < n && j < m) {
            if (arr1.get(i).equals(arr2.get(j))) {
                count++;
                i++;
                j++;
            } else if (arr1.get(i) > arr2.get(j)) {
                j++;
            } else {
                i++;
            }
        }

        Set<Integer> nums = new HashSet<>();
        nums.addAll(arr1);
        nums.addAll(arr2);

        answer.add(count);
        answer.add(nums.size());
        return answer;
    }
}
