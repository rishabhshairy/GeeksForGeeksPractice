package com.dynamicProgramming.strings;

public class DP31ShortestCommonSupersequence {
    public static void main(String[] args) {
        String a = "brute";
        String b = "groot";
        System.out.println(shortestSupersequence(a, b));
    }

    /**
     * First find length of LCS
     * then shortest common supseq will be [n + m - LCS]
     *
     * @param a
     * @param b
     * @return s
     */
    public static String shortestSupersequence(String a, String b) {
        // Write your code here..
        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // scs length => n + m + dp[n][m]
        char[] scs = new char[n + m - dp[n][m]];
        int k = scs.length - 1;

        // Fill answer using DP array
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                scs[k--] = a.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                scs[k--] = a.charAt(i - 1);
                i--;
            } else {
                scs[k--] = b.charAt(j - 1);
                j--;
            }
        }

        // fill remaining string
        while (i > 0) {
            scs[k--] = a.charAt(i - 1);
            i--;
        }

        while (j > 0) {
            scs[k--] = b.charAt(j - 1);
            j--;
        }

        return String.valueOf(scs);
    }
}
