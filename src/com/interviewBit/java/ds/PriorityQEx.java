package com.interviewBit.java.ds;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQEx {
    public static void main(String[] args) {
        PriorityQueue<Integer> nums = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        while (q > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (x == 1) {
                nums.offer(y);
            } else if (x == 2) {
                if (nums.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(nums.peek());
                }
            } else if (x == 3) {
                if (!nums.isEmpty()) {
                    nums.remove();
                }
            }

            q--;
        }
    }
}
