package com.leetCode.matrix.basics;

public class Rotate90 {
    public static void main(String[] args) {
        int matrix[][] = {{4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        rotate(matrix);
    }

    // 2 step process
    // transpose
    // then reverse each row on transposed matrix
    static void rotate(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        // inplace transpose

        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < col; j++) {
                int temp = grid[i][j];
                grid[i][j] = grid[j][i];
                grid[j][i] = temp;
            }
        }

        // now to rotate 90, reverse each row
        for (int[] currRow : grid) {
            int i = 0, j = currRow.length - 1;
            while (i < j) {
                int temp = currRow[j];
                currRow[j] = currRow[i];
                currRow[i] = temp;
                i++;
                j--;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
