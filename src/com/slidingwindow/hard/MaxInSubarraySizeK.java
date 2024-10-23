package com.slidingwindow.hard;

import java.util.*;

public class MaxInSubarraySizeK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        System.out.println(new MaxInSubarraySizeK().max_of_subarrays(3, arr));
    }

    public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> maxQueue = new ArrayDeque<>();

        int left = 0, right = 0;

        while (right < arr.length) {
            // push max element into queue
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < arr[right]) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(arr[right]);

            // when we hit window
            if (right - left + 1 == k) {
                result.add(maxQueue.peekFirst());
                if (maxQueue.peekFirst() == arr[left]) {
                    maxQueue.pollFirst();
                }
                left++;
                right++;
            }

            if (right - left + 1 < k) {
                right++;
            }
        }
//        result.stream().mapToInt(i -> i).toArray();
        return result;
    }
}
