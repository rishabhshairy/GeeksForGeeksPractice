package com.leetCode.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class TakeGiftsFromRichestPile {
    public static void main(String[] args) {
        int[] gifts = {25, 64, 9, 4, 100};
        int k = 4;
        TakeGiftsFromRichestPile obj = new TakeGiftsFromRichestPile();
        obj.pickGifts(gifts, k);
    }

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> sortedQueue = new PriorityQueue<>((x, y) -> y - x);

        for (int i = 0; i < gifts.length; i++) {
            sortedQueue.offer(gifts[i]);
        }
        while (k > 0) {
            int curr = sortedQueue.poll();
            sortedQueue.offer((int) Math.sqrt(curr));
            k--;
        }
        long result = 0;
        while (!sortedQueue.isEmpty()) {
            result += sortedQueue.poll();
        }
//        System.out.println(result);
        return result;
    }
}
