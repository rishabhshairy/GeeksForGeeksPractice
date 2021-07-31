package com.leetcode.array_string_stack;

import java.util.Stack;

public class MinimunRemoveToMakeValidParan {
    public static void main(String[] args) {
        // String s = "lee(t(c)o)de)";
        String s = "(a(b(c)d)";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> brackets = new Stack<>();
        char[] allChars = s.toCharArray();

        for (int i = 0; i < allChars.length; i++) {
            Character ch = allChars[i];
            if (ch.equals('(')) {
                brackets.push(i);
            } else if (ch.equals(')')) {
                if (!brackets.isEmpty()) {
                    brackets.pop();
                } else {
                    allChars[i] = ' ';
                }
            }
        }

        while (!brackets.isEmpty()) {
            allChars[brackets.pop()] = ' ';
        }
        return String.valueOf(allChars).replaceAll(" ", "");
    }
}
