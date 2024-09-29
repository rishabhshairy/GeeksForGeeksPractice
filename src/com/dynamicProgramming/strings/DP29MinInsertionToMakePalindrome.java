package com.dynamicProgramming.strings;


public class DP29MinInsertionToMakePalindrome {
    public static void main(String[] args) {

    }

    /**
     * Approach here is to first find LPS and keep it intact
     * res = n - LPS
     *
     * @param str
     * @return
     */
    public static int minInsertion(String str) {
        // Write your code here.
        String rev = new StringBuilder(str).reverse().toString();

        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return n - dp[n][n];
    }
}
