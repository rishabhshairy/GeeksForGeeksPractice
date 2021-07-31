package com.leetcode.array_string_stack;

import java.util.Stack;

public class ScoreOfParans {
    public static void main(String[] args) {
        String s = "(()(()))";
        System.out.println(scoreOfParentheses(s));
    }

    public static int scoreOfParentheses(String S) {
//        Stack<Integer> bracket = new Stack<>();
//        bracket.push(0);
//
//        for (Character ch :
//                s.toCharArray()) {
//            if (ch == '(') {
//                bracket.push(0);
//            } else {
//                int v = bracket.pop();
//                int w = bracket.pop();
//
//                int depth = w + Math.max(2 * v, 1);
//                bracket.push(depth);
//            }
//        }
//        return bracket.pop();


        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i - 1) == '(')
                    ans += 1 << bal;
                    System.out.println(ans);
            }
        }

        return ans;
    }
}
