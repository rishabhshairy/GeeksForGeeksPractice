package com.stackQueue.prePostFixConversion;

import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        String s = "*+AB-CD";
        System.out.println(preToPost(s));
    }

    /**
     * Read from end
     * for operator pop from stack
     * temp = op1 + op2 + operator
     * @param s
     * @return
     */
    static String preToPost(String s) {
        // code here
        Stack<String> expression = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (isOperator(ch)) {
                String op1 = expression.pop();
                String op2 = expression.pop();
                String temp = op1 + op2 + ch;
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
