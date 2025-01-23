package com.leetCode.bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 1765
 */
public class MapOfHighestPeak {
    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {0, 0}};
        highestPeak(grid);
    }

    public static int[][] highestPeak(int[][] isWater) {
        int rowCount = isWater.length;
        int colCount = isWater[0].length;

        Queue<int[]> waterQueue = new LinkedList<>();

        int[][] result = new int[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (isWater[i][j] == 1) {
                    waterQueue.offer(new int[]{i, j});
                } else {
                    // setting -1 for land cell to calculate height
                    result[i][j] = -1;
                }
            }
        }


        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        // multi-source bfs
        while (!waterQueue.isEmpty()) {
            int[] currWater = waterQueue.poll();
            int row = currWater[0];
            int col = currWater[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = row + deltaRow[i];
                int nextCol = col + deltaCol[i];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < rowCount && nextCol < colCount
                        && result[nextRow][nextCol] == -1) {
                    result[nextRow][nextCol] = result[row][col] + 1;
                    waterQueue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        return result;
    }
}
