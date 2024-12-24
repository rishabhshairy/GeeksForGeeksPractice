package com.leetCode.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class CountUngaurdedCells {
    public static void main(String[] args) {
        int m = 4, n = 6;
        int[][] guards = {{0, 0}, {1, 1}, {2, 3}};
        int[][] walls = {{0, 1}, {2, 2}, {1, 4}};
        countUnguarded(m, n, guards, walls);
    }

    /**
     * Approach:
     * first create a grid marking all guards and walls
     * count all the positions which are non marked
     *
     * Iterate over guarded array
     * go in all 4 directions and for each position found to be protected again
     * go in all 4 direction for new position
     *
     * every time we find a index non-protected reduce the count
     * @param m
     * @param n
     * @param guards
     * @param walls
     * @return
     */
    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];
        int count = (m * n) - guards.length - walls.length;
        // mark gaurd cells
        for (int i = 0; i < guards.length; i++) {
            int row = guards[i][0];
            int col = guards[i][1];
            grid[row][col] = 'g';
        }

        // mark walls
        for (int i = 0; i < walls.length; i++) {
            int row = walls[i][0];
            int col = walls[i][1];
            grid[row][col] = 'w';
        }

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        for (int[] currGuard : guards) {
            int currRow = currGuard[0];
            int currCol = currGuard[1];

            for (int j = 0; j < 4; j++) {
                int nextRow = currRow + deltaRow[j];
                int nextCol = currCol + deltaCol[j];

                while (!(nextRow < 0 || nextCol < 0 || nextRow >= m || nextCol >= n
                        || grid[nextRow][nextCol] == 'g' || grid[nextRow][nextCol] == 'w')) {

                    if (grid[nextRow][nextCol] != 'p') {
                        count--;
                    }
                    grid[nextRow][nextCol] = 'p';

                    // now traverse from this next protected position
                    nextRow += deltaRow[j];
                    nextCol += deltaCol[j];

                }
            }
        }

//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                System.out.print(grid[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println(count);
        return count;
    }
}
