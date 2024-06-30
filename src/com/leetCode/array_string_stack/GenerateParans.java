package com.leetCode.array_string_stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParans {
    public static void main(String[] args) {
        int n = 3;
        for (String br :
                generateParenthesis(n)) {
            System.out.println(br);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        int open = n;
        int close = n;
        String out = "";
//        solve(open, close, out, answer);
        solveDiffApproach(0, 0, out, answer, n);
        return answer;
    }

    private static void solve(int open, int close, String out, List<String> answer) {
        if (open == 0 && close == 0) {
            answer.add(out);
            return;
        }

        if (open != 0) {
            String op1 = out;
            op1 = op1 + "(";
            solve(open - 1, close, op1, answer);
        }
        if (close > open) {
            String op2 = out;
            op2 += ")";
            solve(open, close - 1, op2, answer);
        }
    }

    public static void solveDiffApproach(int leftBracket, int rightBracket, String out, List<String> answer, int n) {
        if (out.length() == 2 * n) {
            answer.add(out);
            return;
        }

        if (leftBracket < n) {
            solveDiffApproach(leftBracket + 1, rightBracket, out + "(", answer, n);
        }

        if (rightBracket < leftBracket) {
            solveDiffApproach(leftBracket, rightBracket + 1, out + ")", answer, n);
        }
    }
}
