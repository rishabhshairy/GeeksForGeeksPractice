package com.dynamicProgramming.strings;

public class DP27LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "wasdijkl";
        String s2 = "wsdjkl";
//        System.out.println(lcs(s1, s2));
        System.out.println(lcsRecusrsive(s1, s2));
    }

    private static int lcsRecusrsive(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        return solve(n, m, n - 1, m - 1, s1, s2, 0);
    }

    private static int solve(int n, int m, int index1, int index2, String s1, String s2, int maxi) {
        if (index1 == 0 || index2 == 0) {
            return maxi;
        }

        if (s1.charAt(index1) == s2.charAt(index2)) {
            maxi = solve(n, m, index1 - 1, index2 - 1, s1, s2, maxi + 1);
        }

        int prev1 = solve(n, m, index1, index2 - 1, s1, s2, 0);
        int prev2 = solve(n, m, index1 - 1, index2, s1, s2, 0);

        maxi = Math.max(maxi, Math.max(prev1, prev2));
        return maxi;
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
