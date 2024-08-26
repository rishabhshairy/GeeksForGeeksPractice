package com.leetCode.arrays;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 * Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
 */
public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}
                , {1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println("Matrix before ops");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        setZeroes(matrix);
        System.out.println("Matrix after ops");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Here Space complexity is O(m+n)
     *
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        // initialise rows and columns for index where element is zero
        int[] row = new int[rowSize];
        int[] col = new int[colSize];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    // set 1 where i & j is Zero
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // mark zero where row and col is 1 for stored index

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void setZeroesOptimal(int[][] matrix) {
        // here row will be matrix[..][0]
        // here col will be matrix[0][..]
        int col0 = 1;
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (matrix[i][j] == 0) {

                    // mark internal row as zero
                    matrix[i][0] = 0;

                    // mark only if j is not zero
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }

                }
            }
        }

        // Now traverse matrix from 1 --> length
        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < colSize; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }

            }
        }

        // Imp step first mark zeros on col ***
        if (matrix[0][0] == 0) {
            for (int j = 0; j < colSize; j++) {
                matrix[0][j] = 0;
            }
        }

        // Now Solve row which is vertical which depends on col0
        if (col0 == 0) {
            for (int i = 0; i < rowSize; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
