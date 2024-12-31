package com.stackQueue.prePostFixConversion;

import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        String s = "ab*c+";
        System.out.println(postToInfix(s));
    }

    /**
     * Read from left to Right
     * for operator pop 2 from stack
     * temp=
     * @param s
     * @return
     */
    static String postToInfix(String s) {
        // code here
        Stack<String> expression = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isOperator(ch)) {
                String op1 = expression.pop();
                String op2 = expression.pop();
                String temp = "(" + op2 + ch + op1 + ")";
                expression.push(temp);
            } else {
                expression.push(ch + "");
            }
        }
        return expression.pop();
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
}
