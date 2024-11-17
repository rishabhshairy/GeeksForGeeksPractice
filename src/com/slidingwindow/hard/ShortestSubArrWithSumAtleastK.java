package com.slidingwindow.hard;

import java.util.PriorityQueue;

public class ShortestSubArrWithSumAtleastK {
    public static void main(String[] args) {
        int[] arr = {2, -1, 2, 1};
        ShortestSubArrWithSumAtleastK obj = new ShortestSubArrWithSumAtleastK();
        System.out.print(obj.shortestSubarray(arr, 3));
    }

    static class Pair<L, I> {
        Long prefixSum;
        Integer index;

        public Pair(Long prefixSum, Integer index) {
            this.prefixSum = prefixSum;
            this.index = index;
        }
    }

    /**
     * Priority Queue Approach
     *
     * @param nums
     * @param k
     * @return
     */
    public int shortestSubarray(int[] nums, int k) {
        PriorityQueue<Pair<Long, Integer>> prefixSumQueue =
                new PriorityQueue<Pair<Long, Integer>>((x, y) -> Long.compare(x.prefixSum, y.prefixSum));

        int n = nums.length;
        long cumulativeSum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            cumulativeSum += nums[i];

            // update the shortest length if cumSum >= k
            if (cumulativeSum >= k) {
                minLen = Math.min(minLen, i + 1);
            }

            // remove sub array to form valid subarray window
            while (!prefixSumQueue.isEmpty() && cumulativeSum - prefixSumQueue.peek().prefixSum >= k) {
                // update shortest length by removing the index of first min element
                minLen = Math.min(minLen, i - prefixSumQueue.poll().index);
            }

            prefixSumQueue.offer(new Pair<Long, Integer>(cumulativeSum, i));

        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
