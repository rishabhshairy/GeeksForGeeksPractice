package com.dynamicProgramming.strings;

import java.util.Arrays;

public class DP32DistinctSubsequences {
    public static void main(String[] args) {
        String s1 = "dingdingdingding";
        String s2 = "ing";
        System.out.println(distinctSubsequencesRecMemo(s1, s2));
    }

    /**
     * Recursive converted to memoized code
     * TC --> O(nxm)
     * SC --> O(nxm) + O(n+m) (stackSpace)
     *
     * @param str
     * @param sub
     * @return
     */
    public static int distinctSubsequencesRecMemo(String str, String sub) {
        // Write your code here.
        int n = str.length();
        int m = sub.length();
        int[][] dp = new int[n][m];
        for (int[] row :
                dp) {
            Arrays.fill(row, -1);
        }

        return findWays(n - 1, m - 1, str, sub, dp);
    }

    private static int findWays(int index1, int index2, String str, String sub, int[][] dp) {

        // base cases
        if (index2 < 0) {
            return 1;
        }

        if (index1 < 0) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        // match case
        // when we only reduce index1 we want to match other occurrence
        // of sub
        if (str.charAt(index1) == sub.charAt(index2)) {
            return dp[index1][index2] = findWays(index1 - 1, index2 - 1, str, sub, dp) +
                    findWays(index1 - 1, index2, str, sub, dp);
        } else {
            return dp[index1][index2] = findWays(index1 - 1, index2, str, sub, dp);
        }
    }

    /**
     * Tabulation Approach
     * Index Shifting --> +1 to all
     * For Comparing i-1
     *
     * @param str
     * @param sub
     * @return
     */
    public static int distinctSubsequencesTabulation(String str, String sub) {
        // Write your code here.
        int n = str.length();
        int m = sub.length();
        int[][] dp = new int[n + 1][m + 1];

        // base case

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j < m + 1; j++) {
            dp[0][j] = 0;
        }

        // Copy Recurrence

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str.charAt(i - 1) == sub.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }
}
