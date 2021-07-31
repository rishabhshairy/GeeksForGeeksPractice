package com.leetcode.array_string_stack;

import java.util.Stack;

public class DailyTemprature {
    public static void main(String[] args) {
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
//        for (Integer num :
//                dailyTemperatures(temp)) {
//            System.out.println(num);
//        }
        dailyTemperatures(temp);
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> temp = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!temp.isEmpty() && temperatures[temp.peek()] < temperatures[i]) {
                int index = temp.pop();
                answer[index] = i - index;
           //     System.out.println(index + " " + i);
            }
            temp.push(i);
        }
        return answer;
    }
}
