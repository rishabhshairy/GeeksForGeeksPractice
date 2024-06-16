package com.leetCode.array_string_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjacent2 {
    public String removeDuplicates(String s, int k) {
        Deque<Pair> pairDeque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (char ch :
                s.toCharArray()) {
            if (pairDeque.size() ==0 || pairDeque.peek().ch != ch) {
                pairDeque.push(new Pair(ch, 1));
            } else {
                pairDeque.push(new Pair(ch, pairDeque.peek().count + 1));
                if (pairDeque.peek().count == k) {
                    int i = 0;
                    while (i < k) {
                        pairDeque.pop();
                        i++;
                    }
                }
            }
        }

        while (!pairDeque.isEmpty()) {
            sb.append(pairDeque.pop().ch);
        }
        return sb.reverse().toString();
    }

    class Pair {
        char ch;
        int count;

        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
