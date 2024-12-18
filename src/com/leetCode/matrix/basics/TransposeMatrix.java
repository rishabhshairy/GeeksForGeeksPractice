package com.leetCode.matrix.basics;

public class TransposeMatrix {
    public static void main(String[] args) {
        int matrix[][] = {{4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        transpose(matrix);

    }

    static void transpose(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] transposed = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        // now transpose
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                transposed[i][j]=grid[j][i];
            }
        }
        System.out.println("===========================");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(transposed[i][j] + " ");
            }
            System.out.println();
        }

    }
}
