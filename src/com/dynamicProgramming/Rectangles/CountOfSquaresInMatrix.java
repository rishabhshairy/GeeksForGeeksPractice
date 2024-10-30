package com.dynamicProgramming.Rectangles;

/**
 * DP 56
 * Count Square Submatrices with All Ones
 */
public class CountOfSquaresInMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}};

        System.out.println(countSquares(matrix));
    }

    public static int countSquares(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        int[][] dp = new int[rowSize][colSize];

        // first fill all rows and columns with same values

        for (int i = 0; i < colSize; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 0; i < rowSize; i++) {
            dp[i][0] = matrix[i][0];
        }

        // now for each col and row of index >1

        for (int row = 1; row < rowSize; row++) {
            for (int col = 1; col < colSize; col++) {
                if (matrix[row][col] == 0) {
                    dp[row][col] = 0;
                } else {
                    dp[row][col] = Math.min(dp[row - 1][col], Math.min(dp[row - 1][col - 1], dp[row][col - 1])) + 1;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                count += dp[i][j];
            }
        }
        return count;
    }
}
