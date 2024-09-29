package com.leetCode.DP;

import java.util.Arrays;

public class LC730CountAllPalindromicSubsequence {
    int MOD = 1_000_000_007;

    public static void main(String[] args) {

    }

    public int countPalindromicSubsequencesMemoization(String s) {
        int[][] dp = new int[1001][1001];
        for (int[] row :
                dp) {
            Arrays.fill(row, -1);
        }
        return solveRecMemo(s, 0, s.length() - 1, dp);
    }

    private int solveRecMemo(String s, int start, int end, int[][] dp) {
        if (start == end) {
            return 1;
        }
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int result = 0;

        if (s.charAt(start) == s.charAt(end)) {

            int left = start + 1;
            int right = end - 1;

            while (left <= right && s.charAt(left) != s.charAt(start)) {
                left++;
            }

            while (left <= right && s.charAt(right) != s.charAt(end)) {
                right--;
            }

            if (left < right) {
                result += 2 * solveRecMemo(s, start + 1, end - 1, dp) - solveRecMemo(s, left + 1, right - 1, dp);
            } else if (left > right) {
                result += 2 * solveRecMemo(s, start + 1, end - 1, dp) + 2;
            } else {
                result += 2 * solveRecMemo(s, start + 1, end - 1, dp) + 1;
            }

        } else {
            result += solveRecMemo(s, start + 1, end, dp)
                    + solveRecMemo(s, start, end - 1, dp)
                    - solveRecMemo(s, start + 1, end - 1, dp);
        }

        return dp[start][end] = result < 0 ? result + MOD : result % MOD;

    }

    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();

        long[][] dp = new long[n][n];
        int mod = 1_000_000_007;

        for (int start = n - 1; start >= 0; start--) {
            dp[start][start] = 1;
            for (int end = start + 1; end < n; end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = 2 * dp[start + 1][end - 1];
                    int left = start + 1;
                    int right = end - 1;
                    while (left <= right && s.charAt(left) != s.charAt(start)) {
                        left++;
                    }

                    while (left <= right && s.charAt(right) != s.charAt(end)) {
                        right--;
                    }

                    if (left > right) {
                        dp[start][end] += 2;
                    } else if (left == right) {
                        dp[start][end] += 1;
                    } else {
                        dp[start][end] -= dp[left + 1][right - 1];
                    }

                } else {
                    dp[start][end] = dp[start + 1][end] + dp[start][end - 1] - dp[start + 1][end - 1];
                }
                dp[start][end] = (dp[start][end] + mod) % mod;
            }
        }

        return (int) dp[0][n - 1];
    }
}
