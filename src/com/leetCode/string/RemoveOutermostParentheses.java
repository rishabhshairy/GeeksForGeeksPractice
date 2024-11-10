package com.leetCode.string;

import java.util.Stack;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }

    private static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (Character ch :
                s.toCharArray()) {
            if (st.isEmpty() && ch == '(') {
                st.push(ch);
            } else if (!st.isEmpty() && ch == '(') {
                st.push(ch);
                sb.append(ch);
            } else if (st.size() > 1 && ch == ')') {
                st.pop();
                sb.append(ch);
            } else if (st.size() == 1 && ch == ')') {
                st.pop();
            }
        }
        return sb.toString();
    }

    public static String removeOuterParenthesesCountApproach(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (Character ch :
                s.toCharArray()) {
            if (ch == '(') {
                if (count != 0) {
                    sb.append(ch);
                }
                count++;
            } else {
                count--;
                if (count != 0) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
