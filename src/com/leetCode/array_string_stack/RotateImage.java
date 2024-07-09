package com.leetCode.array_string_stack;

/**
 * https://leetcode.com/problems/rotate-image/description/
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * Need to do it in-place
 */
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int row = matrix.length;
        int col = matrix[0].length;

        System.out.println("Before Transpose\n");
        printMatrix(matrix, row, col);
        System.out.println("After Transpose\n");
        rotate(matrix);
        printMatrix(matrix, row, col);

    }

    /**
     * Approach
     * 1 --> Transpose matrix --> Make all rows to columns
     * 2 --> Reverse all columns
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        // transpose
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // now to rotate 90 degrees reverse each column
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][row - 1 - j];
                matrix[i][row - 1 - j] = temp;
            }
        }
    }

    public static void printMatrix(int[][] matrix, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
