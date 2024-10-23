package com.slidingwindow.medium;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FruitIntoBasketGFG {
    public static int totalFruits(Integer[] arr) {
        // code here
        int left = 0;
        int right = 0;
        int maxLen = 0;

        HashMap<Integer, Integer> fruitMap = new LinkedHashMap<>();

        while (right < arr.length) {
            fruitMap.put(arr[right], fruitMap.getOrDefault(arr[right], 0) + 1);

            // we have 3 types os fruit now
            if (fruitMap.size() > 2) {
                // remove the count of first element
                fruitMap.put(arr[left], fruitMap.get(arr[left]) - 1);

                if (fruitMap.get(arr[left]) == 0) {
                    fruitMap.remove(arr[left]);
                }
                left++;
            }
            int currWindow = right - left + 1;
            maxLen = Math.max(currWindow, maxLen);
            right++;
        }
        return maxLen;
    }
}
