package com.stackQueue.prePostFixConversion;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String s = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(s));
    }

    public static String infixToPostfix(String s) {
        // Your code here
        StringBuilder sb = new StringBuilder();
        Stack<Character> expression = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            } else if (ch == '(') {
                expression.push(ch);
            } else if (ch == ')') {
                while (!expression.isEmpty() && expression.peek() != '(') {
                    sb.append(expression.pop());
                }
                expression.pop();
            } else {
                // now check precedence and push
                while (!expression.isEmpty() && precedenceOf(ch) <= precedenceOf(expression.peek())) {
                    sb.append(expression.pop());
                }
                expression.push(ch);
            }
        }
        while (!expression.isEmpty()) {
            if (expression.peek() == ')') {
                return "Invalid";
            }
            sb.append(expression.pop());
        }
        return sb.toString();
    }

    private static int precedenceOf(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
