package com.dynamicProgramming.strings;

public class DP27LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "wasdijkl";
        String s2 = "wsdjkl";
        System.out.println(lcs(s1, s2));
    }

    /**
     * We will directly code DP tabulation here
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int lcs(String str1, String str2) {
        // Write your code here.
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
