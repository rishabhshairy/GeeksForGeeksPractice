package com.leetCode.stack.med;

import java.util.Stack;

public class ParanthesisValidationLC2116 {
    public static void main(String[] args) {
//        String s = "))()))", locked = "010100";
        String s = "()()", locked = "0000";
        ParanthesisValidationLC2116 obj = new ParanthesisValidationLC2116();
        System.out.println(obj.canBeValid(s, locked));
    }

    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Integer> openBracket = new Stack<>();
        Stack<Integer> freeIndex = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char lock = locked.charAt(i);
            char ch = s.charAt(i);

            if (lock == '0') {
                freeIndex.push(i);
            } else if (ch == '(') {
                openBracket.push(i);
            } else if (ch == ')') {
                if (!openBracket.isEmpty()) {
                    openBracket.pop();
                } else if (!freeIndex.isEmpty()) {
                    freeIndex.pop();
                } else {
                    return false;
                }
            }
        }

        // match remaining
        while (!openBracket.isEmpty() && !freeIndex.isEmpty()) {
            if (openBracket.peek() < freeIndex.peek()) {
                openBracket.pop();
                freeIndex.pop();
            }
        }

        // when only free indices are left
        if (openBracket.isEmpty() && !freeIndex.isEmpty()) {
            return freeIndex.size() % 2 == 0;
        }

        return openBracket.isEmpty();
    }
}
