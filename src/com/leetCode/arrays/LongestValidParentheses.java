package com.leetCode.arrays;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int count = 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (right > left) {
                left = right = 0;
            } else if (left == right) {
                count = Math.max(count, 2 * right);
            }
        }

        left = right = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left > right) {
                left = right = 0;
            } else if (left == right) {
                count = Math.max(count, 2 * left);
            }
        }
        return count;
    }
}
