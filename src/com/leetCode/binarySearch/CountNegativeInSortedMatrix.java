package com.leetCode.binarySearch;

public class CountNegativeInSortedMatrix {
    public static void main(String[] args) {

    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        int currRow = 0;
        int currCol = col - 1;

        while (currRow < row && currCol >= 0) {
            if (grid[currRow][currCol] >= 0) {
                currRow++;
            } else {
                count += (row - currRow);
                currCol--;
            }
        }
        return count;
    }

    /**
     * This is brute force O(n^2) solution
     *
     * @param grid
     * @return
     */
    public int countNegativesBruteForce(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
