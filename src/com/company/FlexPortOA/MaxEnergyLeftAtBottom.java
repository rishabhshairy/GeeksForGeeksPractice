package com.company.FlexPortOA;

import java.util.Arrays;

/**
 * 3. Matrix Traversal
 * Given a 4 x 4 matrix mat, the initial energy is 100. The task is to reach the last row of the matrix with the maximum possible energy left.
 * ALL
 * Θ
 * The matrix can be traversed in the following way:
 * <p>
 * 1. Start with any cell in the first row.
 * 2. In each move, traverse from cell (i) of the throw and th column to any existing cell out of (i +1. J-1). (i+1, j) or (i+1, j+1).
 * 3. Finish the traversal in the last row.
 * <p>
 * After stepping on a cell (i, j), energy decreases by mat[][] units. Find the maximum possible energy left at the end of the traversal.
 * <p>
 * Note: The final energy can be negative.
 * Example
 * mat=[[10, 20, 30, 40],
 * [60, 50, 20, 80],
 * [10, 10, 10, 10],
 * [60, 50, 60, 50]]
 * Possible paths: 0-based indexing is used.
 */
public class MaxEnergyLeftAtBottom {
    public static void main(String[] args) {
        int[][] mat = {{10, 20, 30, 40},
                {60, 50, 20, 80},
                {10, 10, 10, 10},
                {60, 50, 60, 50}};


        int[] result = new int[4];
        int[][] dp = new int[4][4];

        for (int i = 0; i < 4; i++) {
            int energy = 100;
            result[i] = solve(0, i, mat, energy - mat[0][i], dp);
            System.out.println(result[i]);
        }
    }

    private static int solve(int row, int col, int[][] mat, int energy, int[][] dp) {
        if (col < 0 || col > 3 || row > 3) {
            return (int) 1e9;
        }
        if (row == 3 && col == 3) {
            return energy;
        }

        // solve in all 3 direction

        int leftDiagonal = solve(row + 1, col - 1, mat, energy - mat[row][col], dp);
        int down = solve(row + 1, col, mat, energy - mat[row][col], dp);
        int rightDiagonal = solve(row + 1, col + 1, mat, energy - mat[row][col], dp);

        return Math.min(leftDiagonal, Math.min(down, rightDiagonal));
    }
}
