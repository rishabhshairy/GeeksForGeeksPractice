package com.heapsPQ;

import java.util.PriorityQueue;

public class KthLargestInStream {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargestInStream(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {

        if (minHeap.size() < k || minHeap.peek() < val) {
            minHeap.offer(val);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        System.out.println(minHeap);
        return minHeap.peek();
    }
}
