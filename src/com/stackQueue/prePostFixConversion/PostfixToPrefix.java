package com.stackQueue.prePostFixConversion;

import java.util.Stack;

public class PostfixToPrefix {
    public static void main(String[] args) {
        String s = "ABC/-AK/L-*";
        System.out.println(postToPre(s));
    }

    /**
     * Read from first
     * for operator pop 2 from stack
     * temp = operator + op2 + op1
     *
     * @param s
     * @return
     */
    static String postToPre(String s) {
        // code here
        Stack<String> expression = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isOperator(ch)) {
                String op1 = expression.pop();
                String op2 = expression.pop();
                String temp = ch + op2 + op1;
//                System.out.println(temp);
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
