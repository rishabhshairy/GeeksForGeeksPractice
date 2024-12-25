package com.geeksForGeeks.arrays.level2;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class MinSwapToSort {
    public static void main(String[] args) {
        int[] arr = {10, 19, 6, 3, 5};
        MinSwapToSort obj = new MinSwapToSort();
        obj.minSwaps(arr);
    }

    public int minSwaps(int arr[]) {
        // Code here
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        // Sort the elements
        Arrays.sort(arr);

        // keep a boolean to check visited
        boolean[] visited = new boolean[arr.length];
        Arrays.fill(visited, false);
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {

            // if already visited or correct position
            if (visited[i] || map.get(arr[i]) == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = map.get(arr[j]);
                cycleSize++;
            }
            if (cycleSize > 0) {
                ans += (cycleSize - 1);
            }
        }
        return ans;
    }
}
