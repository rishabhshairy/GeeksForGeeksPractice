package com.dynamicProgramming.strings;

import java.util.Map;

public class DP28LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "bbabcbcab";
    }

    /**
     * Brute Force --> Generate all subsequence and check for longest palindrome
     * Optimal --> reverse the given string and find LCS(s1,rev(s1)
     * To find LCS we will directly code the tabulation
     *
     * @param s
     * @return
     */
    public static int longestPalindromeSubsequence(String s) {
        // Write your code here.
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
}
