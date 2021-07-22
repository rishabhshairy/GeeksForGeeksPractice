package com.interviewbit.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Maxspprod {
    public static void main(String[] args) {
        Integer[] arr = {6, 7, 9, 5, 5, 8};
        ArrayList<Integer> num = new ArrayList<>();
        num.addAll(Arrays.asList(arr));
        System.out.println(maxSpecialProduct(num));
    }

    public static int maxSpecialProduct(ArrayList<Integer> A) {
        //   System.out.println(A.size());
        int[] ngl = new int[A.size()];
        int[] ngr = new int[A.size()];

        long ans = -1;
        int mod = (int) (1e9 + 7);
        Stack<Integer> nums = new Stack<>();

        for (int i = A.size() - 1; i >= 0; i--) {

            while (!nums.isEmpty() && A.get(nums.peek()) < A.get(i)) {
                ngl[nums.pop()] = i;
            }
            nums.push(i);
        }

        while (nums.isEmpty()) {
            ngl[nums.pop()] = -1;
        }

        // next greater to right

        for (int i = 0; i < A.size(); i++) {
            while (!nums.isEmpty() && A.get(nums.peek()) < A.get(i)) {
                ngr[nums.pop()] = i;
            }
            nums.push(i);
        }
        while (nums.isEmpty()) {
            ngr[nums.pop()] = A.size();
        }

        for (int i = 0; i < A.size(); i++) {
            ans = Math.max(ans, (long) ngl[i] * ngr[i]);
        }
        return (int) (ans % mod);
    }
}
