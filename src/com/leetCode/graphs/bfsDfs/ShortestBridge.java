package com.leetCode.graphs.bfsDfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 934
 */
public class ShortestBridge {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
        ShortestBridge obj = new ShortestBridge();
        System.out.println(obj.shortestBridge(grid));
    }

    /**
     * Do DFS to find first island
     *
     * @param grid
     * @return
     */
    public int shortestBridge(int[][] grid) {

        int n = grid.length;
        boolean connected = false;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, queue);
                    connected = true;
                    break;
                }
            }
            // find one island and break
            if (connected) {
                break;
            }
        }


//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(grid[i][j] + " ");
//            }
//            System.out.println();
//        }

        return findMinFlips(queue, grid);
    }

    private int findMinFlips(Queue<int[]> queue, int[][] grid) {
        int count = 0;
        int n = grid.length;

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nextRow = curr[0] + deltaRow[i];
                    int nextCol = curr[1] + deltaCol[i];
                    if (checkBoundary(nextRow, nextCol, grid.length) || grid[nextRow][nextCol] == 2) {
                        continue;
                    }

                    if (grid[nextRow][nextCol] == 1) {
                        return count;
                    } else {
                        grid[nextRow][nextCol] = 2;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }

            }
            count++;
        }
        return -1;
    }

    private void dfs(int row, int col, int[][] grid, Queue<int[]> queue) {
        /**
         *         validate movement
         *         grid == 2 to check for already visited
         *         grid == 0 to check for water
         */
        if (checkBoundary(row, col, grid.length) ||
                grid[row][col] == 2 ||
                grid[row][col] == 0) {
            return;
        }
        grid[row][col] = 2;
        queue.offer(new int[]{row, col});

        // do dfs
        dfs(row - 1, col, grid, queue);
        dfs(row, col + 1, grid, queue);
        dfs(row + 1, col, grid, queue);
        dfs(row, col - 1, grid, queue);
        return;
    }

    private boolean checkBoundary(int nextRow, int nextCol, int n) {
        return nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n;
    }
}
