package com.stackQueue.learning;

import java.util.Stack;

public class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();

        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                brackets.push(')');
            } else if (ch == '{') {
                brackets.push('}');
            } else if (ch == '[') {
                brackets.push(']');
            } else {
                if (!brackets.isEmpty() && brackets.peek().equals(ch)) {
                    brackets.pop();
                } else {
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }
}
