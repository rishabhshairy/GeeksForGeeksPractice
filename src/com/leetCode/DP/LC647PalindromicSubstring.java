package com.leetCode.DP;

public class LC647PalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abcbb"));
    }

    /**
     * Brute force approach
     *
     * @param s
     * @return
     */
    public static int countSubstringsBruteForce(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private static boolean isPalindrome(String substr, int left, int right) {
        while (left < right) {
            if (substr.charAt(left++) != substr.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Expand from middle approach
     */
    public static int countSubstringsExpandApproach(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int even = palindromeCount(s, i, i + 1);
            int odd = palindromeCount(s, i - 1, i + 1);
            ans += even + odd + 1;
        }
        return ans;
    }

    private static int palindromeCount(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            count++;
        }
        return count;
    }

    /**
     * DP
     *
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;

        // base case when length 1 of string is there
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans++;
        }

        // base case for strings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans++;
            }
        }

        // now for length 3 and above
        for (int currLen = 3; currLen <= n; currLen++) {
            for (int left = 0; left < n - currLen + 1; left++) {
                int right = left + currLen - 1;
//                System.out.println(left + " " + right);
//                System.out.println(s.charAt(left) + " " + s.charAt(right));
                if (s.charAt(left) == s.charAt(right) && dp[left + 1][right - 1]) {
                    dp[left][right] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
