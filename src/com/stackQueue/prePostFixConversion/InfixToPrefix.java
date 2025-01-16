package com.stackQueue.prePostFixConversion;

import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        String s = "x+y*z/w+u";
        System.out.println(infixToPrefix(s));
    }

    public static String infixToPrefix(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        Stack<String> expression = new Stack<>();

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < rev.length(); i++) {
            char ch = rev.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            } else if (isOperator(ch)) {
                if (expression.isEmpty()) {
                    expression.push(ch + "");
                }
                // precedence check
                if (precedenceOf(ch) >= precedenceOf(expression.peek().charAt(0))) {
                    expression.push(ch + "");
                } else {

                }
            }
        }
        return "";
    }

    private static boolean isOperator(char ch) {
        switch (ch) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '%':
                return true;
        }
        return false;
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
