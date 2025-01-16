package com.heapsPQ;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    static class MedianFinder {
        PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            minHeap.add(num);
        }

        public double findMedian() {
            int len = minHeap.size();
            if (len == 1) {
                return minHeap.peek();
            }

            if (len % 2 != 0) {

            }
        }
    }
}
