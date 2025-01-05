package com.heapsPQ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class SortKSortedArray {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        mergeKArrays(arr, 3);
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        // Write your code here.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                minHeap.add(arr[i][j]);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }
}
