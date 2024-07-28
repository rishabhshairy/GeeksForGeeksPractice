package com.dynamicProgramming.TwoDimensionDP;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths/description/
 */
public class UniquePath1 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }

    public static int uniquePaths(int m, int n) {
        int row = m;
        int col = n;
        //return solveRecursion(0, 0, row, col);

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        //return solveMemo(0, 0, row, col, dp);
        return uniquePathsTabulation(row, col);
    }

    /**
     * Memoization Approach
     *
     * @param currRow
     * @param currCol
     * @param row
     * @param col
     * @param dp
     * @return
     */
    private static int solveMemo(int currRow, int currCol, int row, int col, int[][] dp) {
        if (currRow >= row || currCol >= col) {
            return 0;
        }
        if (currRow == row - 1 && currCol == col - 1) {
            return 1;
        }

        // check dp for overlapping answers
        if (dp[currRow][currCol] != -1) {
            return dp[currRow][currCol];
        }

        int down = solveMemo(currRow + 1, currCol, row, col, dp);
        int right = solveMemo(currRow, currCol + 1, row, col, dp);
        return dp[currRow][currCol] = down + right;
    }


    /**
     * This is recursive solution
     * This is top-down
     * We can also write a bottom-up approach for this
     * TC --> (2 ^ (mxn)
     * SC --> O(pathlength)
     *
     * @param currRow
     * @param currCol
     * @param row
     * @param col
     * @return
     */
    private static int solveRecursion(int currRow, int currCol, int row, int col) {
        if (currRow >= row || currCol >= col) {
            return 0;
        }
        if (currRow == row - 1 && currCol == col - 1) {
            return 1;
        }

        // Go down --> increase row
        int down = solveRecursion(currRow + 1, currCol, row, col);

        // Go Right --> increase col
        int right = solveRecursion(currRow, currCol + 1, row, col);

        return down + right;
    }

    /**
     * TC --> O(n*m)
     * SC --> O(n*m)
     * We have done tabulation in Bottom up approach manner
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePathsTabulation(int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int left = 0;
                    int up = 0;
                    if (i > 0) {
                        up = dp[i - 1][j];
                    }
                    if (j > 0) {
                        left = dp[i][j - 1];
                    }
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePathsSpaceOptimised(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }
                int up = i > 0 ? dp[j] : 0;
                int left = j > 0 ? temp[j - 1] : 0;
                temp[j] = up + left;

            }
            dp = temp;
        }
        return dp[n - 1];
    }
}
