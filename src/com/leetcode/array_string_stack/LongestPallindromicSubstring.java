package com.leetcode.array_string_stack;

public class LongestPallindromicSubstring {
    public static void main(String[] args) {
        String s = "abbd";
        System.out.println(longestPalindrome(s));
    }

    static String longestPalindrome(String s) {
        // String rev = new StringBuilder(s).reverse().toString();
        if (s == null || s.length() <= 1) {
            return s;
        }
        int n = s.length();
        boolean[][] tdp = new boolean[n][n];

        int longest = 1;
        int start = 0;

        for (int i = 0; i < n; i++) {
            tdp[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                tdp[i][i + 1] = true;
                start = i;
                longest = 2;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j) && tdp[i + 1][j - 1]) {
                    tdp[i][j] = true;
                    if (len > longest) {
                        start = i;
                        longest = len;
                    }
                }
            }

        }

        return s.substring(start, start + longest);
    }
}
