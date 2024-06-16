package com.leetCode.array_string_stack;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOuterParentheses(s));
    }

    public static String removeOuterParentheses(String s) {
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
