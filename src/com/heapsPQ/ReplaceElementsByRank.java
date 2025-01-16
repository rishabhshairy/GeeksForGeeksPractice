package com.heapsPQ;

import java.util.*;

public class ReplaceElementsByRank {
    public static void main(String[] args) {
//        int[] arr = {20, 15, 26, 2, 98, 6};
        int[] arr = {2, 2, 1, 6};
        replaceWithRank(arr, arr.length);
    }

    static int[] replaceWithRank(int arr[], int N) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>((a, b) -> a - b);
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int[] ranks = new int[N];
        for (int num : arr) {
            minheap.offer(num);
        }
        int currentRank = 0;

        while (!minheap.isEmpty()) {
            int top = minheap.poll();
            if (!map.containsKey(top)) {
                map.put(top, ++currentRank);
            }
        }

        for (int i = 0; i < ranks.length; i++) {
            ranks[i] = map.get(arr[i]);
        }

        return ranks;
    }
}
