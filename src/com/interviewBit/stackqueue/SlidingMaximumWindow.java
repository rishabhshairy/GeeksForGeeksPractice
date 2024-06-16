package com.interviewBit.stackqueue;

import java.util.*;

public class SlidingMaximumWindow {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        for (Integer num :
                findMax(Arrays.asList(arr), k)) {
            System.out.println(num);
        }
    }

    public static ArrayList<Integer> findMax(final List<Integer> A, int k) {
            Deque<Integer> maxNum = new ArrayDeque<>();
            ArrayList<Integer> answer = new ArrayList<>();
            Integer[] arr = new Integer[A.size()];

            for (int i = 0; i < A.size(); i++) {
                arr[i] = A.get(i);
            }

            int i;
            for (i = 0; i < k; i++) {
                while (!maxNum.isEmpty() && arr[i] >= arr[maxNum.peekLast()]) {
                    maxNum.removeLast();
                }
                maxNum.addLast(i);
            }

            for (; i < arr.length; i++) {
                answer.add(arr[maxNum.peek()]);

                while (!maxNum.isEmpty() && maxNum.peek() <= i - k) {
                    maxNum.removeFirst();
                }
                while (!maxNum.isEmpty() && arr[i] >= arr[maxNum.peekLast()]) {
                    maxNum.removeLast();
                }
                maxNum.addLast(i);
            }
            answer.add(arr[maxNum.peek()]);
            return answer;
    }
}
