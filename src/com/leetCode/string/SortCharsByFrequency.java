package com.leetCode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharsByFrequency {
    static class Char implements Comparable<Char> {
        char ch;
        int count;

        public Char(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public int compareTo(Char o) {
            return o.count - this.count;
        }
    }

    /**
     * Priority Queue Approach
     * TC --> O (nlogN)
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        Map<Character, Integer> charMap = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Char> queue = new PriorityQueue<>();
        for (Character ch : charMap.keySet()) {
            queue.offer(new Char(ch, charMap.get(ch)));
        }

        String result = "";
        while (!queue.isEmpty()) {
            Char curr = queue.remove();
            // append total characters
            for (int i = 0; i < curr.count; i++) {
                result += curr.ch;
            }
        }
        return result;
    }
}
