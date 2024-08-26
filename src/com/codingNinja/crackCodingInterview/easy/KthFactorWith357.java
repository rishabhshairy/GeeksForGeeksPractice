package com.codingNinja.crackCodingInterview.easy;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthFactorWith357 {
    public static void main(String[] args) {
        System.out.println(findKthElement(10));
    }

    public static long findKthElement(int k) {
        // Write your code here.
        Queue<Long> q3 = new ArrayDeque<>();
        Queue<Long> q5 = new ArrayDeque<>();
        Queue<Long> q7 = new ArrayDeque<>();

        long x = 1;

        for (int i = 1; i <= k; i++) {
            q3.add(x * 3);
            q5.add(x * 5);
            q7.add(x * 7);

            x = Math.min(Math.min(q3.peek(), q5.peek()), q7.peek());
            if (x == q3.peek()) {
                q3.poll();
            }
            if (x == q5.peek()) {
                q5.poll();
            }
            if (x == q7.peek()) {
                q7.poll();
            }
        }
        return x;
    }
}
