package com.interviewbit.twopointers;

import java.util.Stack;

public class RedundantBraces {
    public static void main(String[] args) {
        String s = "((a+b))";
        System.out.println(braces(s));
    }

    public static int braces(String A) {
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            int count = 0;
            if (A.charAt(i) == ')') {
                if (brackets.peek() == '(') {
                    return 1;
                } else {
                    while (brackets.peek() != '(') {
                        brackets.pop();
                        count++;
                    }
                    if (count == 1) {
                        return 1;
                    }
                    brackets.pop();
                }
            } else {
                brackets.push(A.charAt(i));
            }
        }
        return 0;
    }
}
