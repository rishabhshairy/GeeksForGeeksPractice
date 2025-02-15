package com.heapsPQ;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] answer = topKFrequent(nums, k);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    /**
     * @implNote Heap Approach will use lots of space
     * @param nums
     * @param k
     * @return
     */
    static int[] topKFrequent(int[] nums, int k) {
        int[] answer = new int[k];
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        Queue<Integer> heapQueue = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        for (Integer key : freqMap.keySet()) {
            heapQueue.add(key);
        }
        for (int i = 0; i < k; i++) {
            answer[i] = heapQueue.poll();
        }
        return answer;
    }
}
