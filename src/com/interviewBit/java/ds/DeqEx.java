package com.interviewBit.java.ds;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DeqEx {
    public static void main(String[] args) {
        Deque<Integer> nums = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        while (q > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x == 1) {
                nums.addLast(y);
            } else if (x == 2) {
                nums.addFirst(y);
            } else if (x == 3) {
                if (nums.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(nums.peekFirst());
                }
            } else if (x == 4) {
                if (nums.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(nums.peekLast());
                }
            } else if (x == 5) {
                if (!nums.isEmpty()) {
                    nums.removeFirst();
                }
            } else if (x == 6) {
                if (!nums.isEmpty()) {
                    nums.removeLast();
                }
            }
            q--;
        }
        sc.close();
    }
}
