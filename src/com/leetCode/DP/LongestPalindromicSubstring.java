package com.leetCode.DP;

/**
 * LC 5 --> https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String a = "abacdfgdcaba";
        System.out.println(longestPalindrome(a));
    }

    /**
     * We will use concept of LCS ( s, rev(s)
     * LCS --> longest common substring
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        int n = s.length();
        int m = rev.length();
        int[][] dp = new int[n + 1][m + 1];
        int maxPalindromeSubstringLength = 0;
        int endIndex = 0;

        int rowP = 0, colP = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    if (maxPalindromeSubstringLength < dp[i][j]) {

                        int iStart = i - dp[i][j];
                        int jEnd = j;

                        if (iStart == s.length() - jEnd) {
                            maxPalindromeSubstringLength = dp[i][j];
                            endIndex = i;
                        }

                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        System.out.println(maxPalindromeSubstringLength);

        return s.substring(endIndex - maxPalindromeSubstringLength, endIndex);
    }
}
