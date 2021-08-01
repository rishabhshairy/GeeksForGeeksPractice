package com.leetcode.array_string_stack;

import java.util.LinkedList;
import java.util.Queue;

public class RevealCards {
    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        deckRevealedIncreasing(deck);
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        int[] answer = new int[deck.length];
        Queue<Integer> deckIndexQueue = new LinkedList<>();

        for (int i = 0; i < deck.length; i++) {
            deckIndexQueue.offer(i);
        }
        System.out.println(deckIndexQueue.toString());
        for (Integer num :
                deck) {
            answer[deckIndexQueue.poll()] = num;
            if (!deckIndexQueue.isEmpty()) {
                deckIndexQueue.offer(deckIndexQueue.poll());
            }
        }
        return answer;
    }
}
