package com.leetCode.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ConstructStringWithRepeatLimit {
    public static void main(String[] args) {
        String s = "cczazcc";
        int repeatLimit = 3;
        ConstructStringWithRepeatLimit obj = new ConstructStringWithRepeatLimit();
        System.out.println(obj.repeatLimitedString(s, repeatLimit));
    }

    /**
     * Approach
     * Count Freq of chars
     * Put the unique chars in PQ
     * <p>
     * main trick here is to how to find breaker i.e. switch over to next char
     *
     * @param s
     * @param repeatLimit
     * @return
     */
    public String repeatLimitedString(String s, int repeatLimit) {

        Map<Character, Integer> freqMap = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((x, y) -> Character.compare(y, x));
        for (Character ch : freqMap.keySet()) {
            maxHeap.offer(ch);
        }

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Character curr = maxHeap.poll();
            int count = freqMap.get(curr);
            int usable = Math.min(repeatLimit, count);

            for (int i = 0; i < usable; i++) {
                result.append(curr);
            }

            freqMap.put(curr, count - usable);
            System.out.println(freqMap);
            // now this is the point for break over
            // if still current character is left, switch over to next character
            if (freqMap.get(curr) > 0 && !maxHeap.isEmpty()) {
                Character next = maxHeap.poll();
                int nextCount = freqMap.get(next);
                result.append(next);

                // update max of next
                freqMap.put(next, nextCount - 1);

                // put only if next character have count left
                if (freqMap.get(next) > 0) {
                    maxHeap.offer(next);
                }
                maxHeap.offer(curr);
            }
        }

        return result.toString();
    }
}
