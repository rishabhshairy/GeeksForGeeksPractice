package com.dynamicProgramming.strings;

import java.util.*;

public class DP26PrintLCS {
    public static void main(String[] args) {
        System.out.println(all_longest_common_subsequences("abaaa", "baabaca"));
    }

    /**
     * To just print one LCS
     *
     * @param s
     * @param t
     * @return
     */
    public static List<String> all_longest_common_subsequencesOnlyOne(String s, String t) {
        // Code here

        // first find length of LCS
        List<String> result = new ArrayList<>();
        int n1 = s.length();
        int n2 = s.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcs = dp[n1][n2];
        char[] lcsChars = new char[lcs];
        int k = lcsChars.length - 1;

        System.out.println(lcs);

        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int i = n1;
        int j = n2;

        // This will print only one LCS
        while (i > 0 && j > 0) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                lcsChars[k--] = s.charAt(i - 1);
                i--;
                j--;
            } else if (s.charAt(i - 1) > t.charAt(j - 1)) {
                i--;
            } else {
                j--;
            }
        }
        result.add(String.valueOf(lcsChars));
        return result;
    }

    public static List<String> all_longest_common_subsequences(String s, String t) {
        // Code here
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // need to use backtracking and recursion to find all LCS
        Set<String> result = new HashSet<>();

        // will be used for memoization
        Map<String, List<String>> memoMap = new HashMap<>();
        backtrack(dp, s, t, n, m, "", result, memoMap);
        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);
        return answer;
    }

    private static void backtrack(int[][] dp, String s, String t, int index1, int index2, String lcs, Set<String> result, Map<String, List<String>> memoMap) {

        // base case when strings are exhausted
        if (index1 == 0 || index2 == 0) {
            result.add(new StringBuilder(lcs).reverse().toString());
            return;
        }

        // form key for map
        String key = index1 + "," + index2 + "," + lcs;

        // Check for memoization
        if (memoMap.containsKey(key)) {
            result.addAll(memoMap.get(key));
            return;
        }

        // Core Logic
        if (s.charAt(index1 - 1) == t.charAt(index2 - 1)) {
            backtrack(dp, s, t, index1 - 1, index2 - 1, lcs + s.charAt(index1 - 1), result, memoMap);
        } else {
            // Now the two possibilities which filled DP array

            if (dp[index1 - 1][index2] == dp[index1][index2]) {
                backtrack(dp, s, t, index1 - 1, index2, lcs, result, memoMap);
            }
            if (dp[index1][index2 - 1] == dp[index1][index2]) {
                backtrack(dp, s, t, index1, index2 - 1, lcs, result, memoMap);
            }
        }

        List<String> list = new ArrayList<>(result);
        memoMap.put(key, list);
    }
}
