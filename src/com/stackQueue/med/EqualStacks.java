package com.stackQueue.med;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

public class EqualStacks {
    public static void main(String[] args) throws IOException {

        List<Integer> h1 = Arrays.asList(3, 2, 1, 1, 1);
        List<Integer> h2 = Arrays.asList(4, 3, 2);
        List<Integer> h3 = Arrays.asList(1, 1, 4, 1);


        int result = EqualStacks.equalStacks(h1, h2, h3);

    }

    /**
     * Works for small size
     * TC O(n^2)
     *
     *
     * @param h1
     * @param h2
     * @param h3
     * @return
     */
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> s1 = getStack(h1);
        Stack<Integer> s2 = getStack(h2);
        Stack<Integer> s3 = getStack(h3);

        System.out.println(s1);

        int sum1 = getStackSum(s1);
        int sum2 = getStackSum(s2);
        int sum3 = getStackSum(s3);

        int mini = Math.min(sum1, Math.min(sum2, sum3));

        if (sum1 == sum2 && sum2 == sum3) {
            return sum1;
        }

        while (true) {

            if (sum1 > mini) {
                s1.pop();
                sum1 = getStackSum(s1);
            }
            if (sum2 > mini) {
                s2.pop();
                sum2 = getStackSum(s2);
            }
            if (sum3 > mini) {
                s3.pop();
                sum3 = getStackSum(s3);
            }
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }
            mini = Math.min(sum1, Math.min(sum2, sum3));
        }
    }


    private static int getStackSum(Stack<Integer> stack) {
        return stack.stream().mapToInt(Integer::intValue).sum();
    }

    private static Stack<Integer> getStack(List<Integer> height) {
        Stack<Integer> stack = new Stack<>();
        for (int i = height.size() - 1; i >= 0; i--) {
            stack.push(height.get(i));
        }
        return stack;
    }

}
