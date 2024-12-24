package com.leetCode.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FinalStateAfterKMultiply {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6};
        int k = 5, multiplier = 2;
        FinalStateAfterKMultiply obj = new FinalStateAfterKMultiply();
        obj.getFinalState(nums, k, multiplier);
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((x, y) -> {
            int comp = Integer.compare(x[0], y[0]);

            if (comp == 0) {
                return Integer.compare(x[1], y[1]);
            }
            return comp;
        });

        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i});
        }

        while (k-- > 0) {
            int[] currMin = minHeap.poll();
            int index = currMin[1];
            int val = multiplier * currMin[0];
            nums[index] = val;
            minHeap.offer(new int[]{val, index});
        }

        return nums;
    }
}
