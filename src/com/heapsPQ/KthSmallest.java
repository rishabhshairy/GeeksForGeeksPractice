package com.heapsPQ;

import java.util.PriorityQueue;

public class KthSmallest {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int num : arr) {
            maxHeap.add(num);
        }

        while (k-- > 1) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
