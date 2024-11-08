package com.leetCode.greedy;

import java.util.Arrays;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "(*()";
        System.out.println(new ValidParentheses().checkValidString(s));
    }

    private boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                min += 1;
                max += 1;
            } else if (s.charAt(i) == ')') {
                min -= 1;
                max -= 1;
            } else {
                min -= 1;
                max += 1;
            }

            if (min < 0) {
                min = 0;
            }
            if (max < 0) {
                return false;
            }
        }
        return min == 0;
    }

    /**
     * Stack Approach
     *
     * @param s
     * @return
     */
    private boolean checkValidStringStack(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> asterisk = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open.push(i);
            } else if (s.charAt(i) == '*') {
                asterisk.push(i);
            } else {
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!asterisk.isEmpty()) {
                    asterisk.pop();
                } else {
                    return false;
                }
            }
        }

        // now use open and asterik to balance remaining string
        while (!open.isEmpty() && !asterisk.isEmpty()) {
            if (open.pop() > asterisk.pop()) {
                return false;
            }
        }

        // if all brackets are matched open stack should be empty
        return open.isEmpty();
    }

    /**
     * Bottom up DP approach
     *
     * @param s
     * @return
     */
    public boolean checkValidStringTopDownDP(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        dp[n][0] = true;
        for (int index = n - 1; index >= 0; index--) {
            for (int openBrackets = 0; openBrackets < n; openBrackets++) {
                // two conditions here
                boolean valid = false;
                if (s.charAt(index) == '*') {
                    valid |= dp[index + 1][openBrackets + 1];

                    // considering * as )
                    if (openBrackets > 0) {
                        valid |= dp[index + 1][openBrackets - 1];
                    }
                    valid |= dp[index + 1][openBrackets];
                } else {
                    if (s.charAt(index) == '(') {
                        valid = dp[index + 1][openBrackets + 1];
                    } else if (openBrackets > 0) {
                        valid = dp[index + 1][openBrackets - 1];
                    }
                }
                dp[index][openBrackets] = valid;
            }
        }
        return dp[0][0];
    }

    /**
     * Recursion and Memoization
     *
     * @param s
     * @return
     */
    public boolean checkValidStringRecMemo(String s) {
        int count = 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solveRecMemo(s, 0, count, dp);
    }

    private boolean solveRecMemo(String s, int index, int count, int[][] dp) {
        if (count < 0) {
            return false;
        }

        // base case 2
        if (index == s.length()) {
            return count == 0;
        }

        if (dp[index][count] != -1) {
            return dp[index][count] == 1;
        }
        boolean valid = false;
        // now check for parenthesis
        if (s.charAt(index) == '(') {
            valid = solveRecMemo(s, index + 1, count + 1, dp);
        } else if (s.charAt(index) == ')') {
            valid = solveRecMemo(s, index + 1, count - 1, dp);
        } else {

            /**
             * here count + 1 --> replacing * with (
             * count - 1 --> replacing & with )
             */
            valid |= solveRecMemo(s, index + 1, count + 1, dp) || solveRecMemo(s, index + 1, count - 1, dp) || solveRecMemo(s, index + 1, count, dp);
        }
        dp[index][count] = valid ? 1 : 0;
        return valid;
    }
}
