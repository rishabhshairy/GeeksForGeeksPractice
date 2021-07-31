package com.leetcode.array_string_stack;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        String s1 = "bbbaaaba";
        String s2 = "bbababbb";
        System.out.println(shortestCommonSupersequence(s1, s2));
    }

    static String shortestCommonSupersequence(String X, String Y) {
        int n = X.length();
        int m = Y.length();

        int[][] tdp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    tdp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    tdp[i][j] = 1 + tdp[i - 1][j - 1];
                } else {
                    tdp[i][j] = Math.max(tdp[i - 1][j], tdp[i][j - 1]);
                }
            }
        }

        int i = n;
        int j = m;
        StringBuilder scs = new StringBuilder();

        while (i > 0 && j > 0) {
            char current;
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                current = X.charAt(i - 1);
                i--;
                j--;
            } else {
                if (tdp[i][j - 1] > tdp[i - 1][j]) {
                    current = Y.charAt(j - 1);
                    j--;
                } else {
                    current = X.charAt(i - 1);
                    i--;
                }
            }
            scs.append(current);
        }

        while (i > 0) {
            scs.append(X.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            scs.append(Y.charAt(j - 1));
            j--;
        }

        return scs.reverse().toString();
    }
}
