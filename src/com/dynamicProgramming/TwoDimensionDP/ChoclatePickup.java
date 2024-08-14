package com.dynamicProgramming.TwoDimensionDP;

import java.util.Arrays;

public class ChoclatePickup {
    public static void main(String[] args) {

    }

    public static int maximumChocolatesRecursiveMemoization(int row, int col, int[][] grid) {
        // Write your code here.
        int[][][] dp = new int[row][col][col];
        for (int row1[][] : dp) {
            for (int row2[] : row1) {
                Arrays.fill(row2, -1);
            }
        }
        return solveRecMemo(0, 0, col - 1, grid, row, col, dp);
    }

    private static int solveRecMemo(int currRow, int colAlice, int colBob, int[][] grid, int row, int col, int[][][] dp) {

        // Writing boundary conditions
        if (colAlice < 0 || colAlice >= col || colBob < 0 || colBob >= col) {
            return (int) Math.pow(-10, 9);
        }

        // Base Case
        if (currRow == row - 1) {
            if (colAlice == colBob) {
                return grid[currRow][colAlice];
            } else {
                return grid[currRow][colAlice] + grid[currRow][colBob];
            }
        }

        // Check for DP index
        if (dp[currRow][colAlice][colBob] != -1) {
            return dp[currRow][colAlice][colBob];
        }

        // As explained for every movement of Alice there will be 3 movement of Bob
        int maxChocolates = Integer.MIN_VALUE;
        for (int da = -1; da <= 1; da++) {
            for (int db = -1; db <= 1; db++) {
                int ans;
                if (colAlice == colBob) {
                    ans = grid[currRow][colAlice] +
                            solveRecMemo(currRow + 1, colAlice + da, colBob + db, grid, row, col, dp);
                } else {
                    ans = grid[currRow][colAlice] + grid[currRow][colBob] +
                            solveRecMemo(currRow + 1, colAlice + da, colBob + db, grid, row, col, dp);
                }
                maxChocolates = Math.max(ans, maxChocolates);
            }
        }
        return dp[currRow][colAlice][colBob] = maxChocolates;
    }

    /**
     * Tabulation Solution
     *
     * @param row
     * @param col
     * @param grid
     * @return
     */
    public static int maximumChocolates(int n, int m, int[][] grid) {
        // Write your code here.
        int dp[][][] = new int[n][m][m];

        // Initialize the dp array with values from the last row of the grid
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                else
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        // Outer nested loops to traverse the DP array from the second last row to the first row
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) { // for alice
                for (int j2 = 0; j2 < m; j2++) { // for bob
                    int maxi = Integer.MIN_VALUE;

                    // Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;

                            if (j1 == j2)
                                ans = grid[i][j1];
                            else
                                ans = grid[i][j1] + grid[i][j2];

                            // Check if the indices are valid
                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += dp[i + 1][j1 + di][j2 + dj];

                            // Update maxi with the maximum result
                            maxi = Math.max(ans, maxi);
                        }
                    }
                    // Store the result in the dp array
                    dp[i][j1][j2] = maxi;
                }
            }
        }

        // The final result is stored at the top row (first row) of the dp array
        return dp[0][0][m - 1];
    }
}
