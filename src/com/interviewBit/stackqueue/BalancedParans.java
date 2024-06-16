package com.interviewBit.stackqueue;

import java.util.Stack;

public class BalancedParans {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(solve(s));
    }

    public static int solve(String s) {
        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                brackets.push(')');
            } else if (brackets.isEmpty() || brackets.pop() != s.charAt(i)) {
                return 0;
            }
        }
        return brackets.isEmpty() ? 1 : 0;
    }
}
