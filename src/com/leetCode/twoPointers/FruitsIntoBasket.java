package com.leetCode.twoPointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitsIntoBasket {
    public static void main(String[] args) {
        int[] fruits = {0, 1, 2, 2};
        System.out.println(totalFruitOptimal(fruits));
    }

    public static int totalFruitBruteForce(int[] fruits) {

        int n = fruits.length;
        Set<Integer> set = new HashSet<>();
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            set.clear();  // Clear the set for each new starting point
            for (int j = i; j < n; j++) {
                set.add(fruits[j]);
                if (set.size() <= 2) {
                    maxi = Math.max(maxi, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxi;
    }

    /**
     * Two pointer and sliding window
     *
     * @param fruits
     * @return
     */
    public static int totalFruitOptimal(int[] fruits) {
        Map<Integer, Integer> countMap = new HashMap<>();

        int l = 0, r = 0, maxLen = 0;
        while (r < fruits.length) {
            countMap.put(fruits[r], countMap.getOrDefault(fruits[r], 0) + 1);
            if (countMap.size() > 2) {
                countMap.put(fruits[l], countMap.get(fruits[l]) - 1);
                if (countMap.get(fruits[l]) == 0) {
                    countMap.remove(fruits[l]);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
