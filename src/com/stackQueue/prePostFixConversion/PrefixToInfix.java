package com.stackQueue.prePostFixConversion;

import java.util.Stack;

/**
 *
 */
public class PrefixToInfix {
    public static void main(String[] args) {
        String s = "*-A/BC-/AKL";
        System.out.println(preToInfix(s));
    }

    /**
     * read from enc
     * Push operand to stack
     * if its operator, get 2 operand from stack
     * s = op1 + operator + op2
     * push s back to stack
     *
     * @param s
     * @return
     */
    static String preToInfix(String s) {
        // code here
        Stack<String> expression = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (isOperator(ch)) {
                if (!expression.isEmpty()) {
                    String operand1 = expression.pop();
                    String operand2 = expression.pop();
                    String temp = sb.append("(" + operand1).append(ch).append(operand2 + ")").toString();
                    expression.push(temp);
                    sb = new StringBuilder();
                }
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
