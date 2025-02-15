package com.leetCode.heaps;

import java.util.PriorityQueue;

public class MinOpsToExceedThreshold {
    public int minOperations(int[] nums, int k) {

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (Integer num : nums) {
            minHeap.add(Long.valueOf(num));
        }
        int ops = 0;
        while (!minHeap.isEmpty() && minHeap.size() > 1) {
            Long x = minHeap.poll();
            Long y = minHeap.poll();

            if (x < k || y < k) {
                Long res = Math.min(x, y) * 2 + Math.max(x, y);
                minHeap.add(res);
                ops++;
            } else {
                minHeap.add(x);
                minHeap.add(y);
                break;
            }


        }
        return ops;
    }
}
