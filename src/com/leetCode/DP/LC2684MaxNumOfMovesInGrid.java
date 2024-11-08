package com.leetCode.DP;

import java.util.Arrays;

public class LC2684MaxNumOfMovesInGrid {
    public static void main(String[] args) {
        int[][] grid = {{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}};
        System.out.print(maxMoves(grid));
//        System.out.print(maxMovesRecMemo(grid));
    }

    /**
     * Lets try tabulation
     *
     * @param grid
     * @return
     */
    public static int maxMoves(int[][] grid) {
        int maxRow = grid.length - 1;
        int maxCol = grid[0].length - 1;
        int[][] table = new int[maxRow + 1][maxCol + 1];
        int res = 0;

        for (int col = maxCol; col >= 0; col--) {
            for (int row = 0; row <= maxRow; row++) {
                int diagonalUp = 0, right = 0, diagonalDown = 0;

                if (row - 1 >= 0 && col + 1 <= maxCol && grid[row - 1][col + 1] > grid[row][col]) {
                    diagonalUp = 1 + table[row - 1][col + 1];
                }

                if (col + 1 <= maxCol && grid[row][col + 1] > grid[row][col]) {
                    right = 1 + table[row][col + 1];
                }

                if (row + 1 <= maxRow && col + 1 <= maxCol && grid[row + 1][col + 1] > grid[row][col]) {
                    diagonalDown = 1 + table[row + 1][col + 1];
                }

                table[row][col] = Math.max(diagonalUp, Math.max(right, diagonalDown));
                if (col == 0) res = Math.max(res, table[row][0]);
            }
        }

        return res;

    }

    public static int maxMovesRecMemo(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;

        int[][] dp = new int[rowSize][colSize];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        // fill all the last columns with 1 for base case
        int maxMoves = 0;
        for (int row = 0; row < rowSize; row++) {
            int currMove = solve(row, 0, grid, dp, rowSize, colSize);
            maxMoves = Math.max(currMove, maxMoves);
        }

//        for (int i = 0; i < rowSize; i++) {
//            for (int j = 0; j < colSize; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        return maxMoves;
    }

    private static int solve(int row, int col, int[][] grid, int[][] dp, int rowSize, int colSize) {
        // basecase --> when we cross boundaries
        if (row < 0 || col > colSize || row > rowSize) {
            return 1;
        }

        // memoization
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        // now use pick/non-pick
        // upward Right
        int upRight = 0;
        int right = 0;
        int downRight = 0;
        // diagonalUp
        if (row - 1 >= 0 && col + 1 < colSize) {
            if (grid[row][col] < grid[row - 1][col + 1]) {
                upRight = 1 + solve(row - 1, col + 1, grid, dp, rowSize, colSize);
            }
        }

        // move right
        if (col + 1 < colSize) {
            if (grid[row][col] < grid[row][col + 1]) {
                right = 1 + solve(row, col + 1, grid, dp, rowSize, colSize);
            }
        }

        // diagonalDown
        if (row + 1 < rowSize && col + 1 < colSize) {
            if (grid[row][col] < grid[row + 1][col + 1]) {
                downRight = 1 + solve(row + 1, col + 1, grid, dp, rowSize, colSize);
            }
        }

        return dp[row][col] = Math.max(upRight, Math.max(right, downRight));
    }
}
