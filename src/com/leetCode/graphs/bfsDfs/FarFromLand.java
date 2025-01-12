package com.leetCode.graphs.bfsDfs;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * LC 1162
 */
public class FarFromLand {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        FarFromLand obj = new FarFromLand();
        obj.maxDistance(grid);
    }

    /**
     * Use multi source BFS
     *
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] distance = new int[n][n];
        Queue<int[]> nodeQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    nodeQueue.offer(new int[]{i, j});
                }
            }
        }

        if (nodeQueue.size() == 0 || nodeQueue.size() == n * n) {
            return -1;
        }

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        int max = -1;
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            while (size-- > 0) {
                int[] curr = nodeQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int nextRow = curr[0] + deltaRow[i];
                    int nextCol = curr[1] + deltaCol[i];

                    if (!isValid(nextRow, nextCol, grid.length) && grid[nextRow][nextCol] == 0) {
                        grid[nextRow][nextCol] = 1;
                        nodeQueue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
            max++;
        }
        System.out.println(max);
        return max;
    }

    private boolean isValid(int nextRow, int nextCol, int n) {
        return nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n;
    }

}
