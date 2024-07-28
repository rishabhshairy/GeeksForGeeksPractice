package com.dynamicProgramming.TwoDimensionDP;

import java.util.Arrays;

/**
 * LC --> https://leetcode.com/problems/minimum-path-cost-in-a-grid/description/
 */
public class MinimumPathCostInGrid {
    public static void main(String[] args) {
        int[][] arr = {{5, 3}, {4, 0}, {2, 1}};
        int[][] moveCost = {{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}};


        System.out.println(minPathCostFromTopLeft(arr, moveCost));
    }

    public static int minPathCostFromTopLeft(int[][] grid, int[][] moveCost) {

        // Idea is to Stand at each column in the first row and move to each column in the next row.
        // Repeat the process recursively for each row.
        int row = grid.length;
        int col = grid[0].length;
        int ans = Integer.MAX_VALUE;

        // memoize
        int[][] dp = new int[row + 1][col + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        for (int j = 0; j < col; j++) {
            ans = Math.min(ans, solve(0, j, row, col, grid, moveCost, dp));
        }

        return ans;
    }

    private static int solve(int currRow, int currCol, int row, int col, int[][] grid, int[][] moveCost, int[][] dp) {


        if (currRow == row - 1) {
            return grid[currRow][currCol];
        }

        if (dp[currRow][currCol] != -1) {
            return dp[currRow][currCol];
        }

        int totalCost = Integer.MAX_VALUE;

        // Again move from column 0 --> col-1

        for (int j = 0; j < col; j++) {
            int pathCost = grid[currRow][currCol];
            int currMoveCost = moveCost[pathCost][j];
            totalCost = Math.min(totalCost, solve(currRow + 1, j, row, col, grid, moveCost, dp) + pathCost + currMoveCost);
        }

        return dp[currRow][currCol] = totalCost;
    }
}

//        int down = grid[currRow][currCol] + solve(currRow + 1, currCol, row, col, grid, grid);
//        int across = grid[currRow][currCol] + solve(currRow + 1, currCol + 1, row, col, grid, grid);