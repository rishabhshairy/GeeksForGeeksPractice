package com.heapsPQ;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * VVIMP
 */
public class KthLargest {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        KthLargest obj = new KthLargest();
        obj.findKthLargest(nums, 4);

    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            maxHeap.add(num);
        }

        while (k-- > 1) {
            maxHeap.poll();
        }
        System.out.print(maxHeap);
        return maxHeap.peek();
    }
}
